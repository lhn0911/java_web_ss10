package com.rikkei.ss10.repository;

import com.rikkei.ss10.model.Account;
import com.rikkei.ss10.utils.ConnectionDB;
import org.springframework.stereotype.Repository;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

@Repository
public class AccountDaoImp implements AccountDao{

    @Override
    public boolean save(String username, String password, String email) {
        Connection conn = null;
        CallableStatement callSt = null;
        Account account = null;
        try {
            conn = ConnectionDB.openConnection();
            callSt = conn.prepareCall("{call save(?,?,?)}");
            callSt.setString(1, username);
            callSt.setString(2, password);
            callSt.setString(3, email);
            callSt.executeUpdate();
            ResultSet rs = callSt.getResultSet();
            while (rs.next()) {
                account = new Account();
                account.setUsername(rs.getString("username"));
                account.setPassword(rs.getString("password"));
                account.setEmail(rs.getString("email"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            ConnectionDB.closeConnection(conn, callSt);
        }
        return true;
    }
}
