package com.rikkei.ss10.repository;

import com.rikkei.ss10.model.DocumentB7;
import com.rikkei.ss10.utils.ConnectionDB;
import org.springframework.stereotype.Repository;

import java.sql.CallableStatement;
import java.sql.Connection;

@Repository
public class DocumentDaoImp implements DocumentDao{
    @Override
    public boolean createDocument(DocumentB7 document) {
        Connection conn = null;
        CallableStatement callSt = null;
        boolean result = false;
        try {
            conn = ConnectionDB.openConnection();
            callSt = conn.prepareCall("{call create_doccument(?, ?, ?)}");
            callSt.setString(1, document.getTitle());
            callSt.setString(2, document.getDescription());
            callSt.setBytes(3, document.getFile().getBytes());
            callSt.executeUpdate();
            result = true;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            ConnectionDB.closeConnection(conn, callSt);
        }
        return result;
    }
}
