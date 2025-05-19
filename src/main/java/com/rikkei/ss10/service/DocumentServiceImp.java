package com.rikkei.ss10.service;

import com.rikkei.ss10.model.DocumentB7;
import com.rikkei.ss10.repository.DocumentDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DocumentServiceImp implements DocumentService{
    @Autowired
    private DocumentDao documentDao;
    @Override
    public boolean createDocument(DocumentB7 document) {
        return documentDao.createDocument(document);
    }
}
