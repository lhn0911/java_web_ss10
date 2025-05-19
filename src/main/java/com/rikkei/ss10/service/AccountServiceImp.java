package com.rikkei.ss10.service;

import com.rikkei.ss10.model.Account;
import com.rikkei.ss10.repository.AccountDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AccountServiceImp implements AccountService{
    @Autowired
    private AccountDao accountDao;
    @Override
    public boolean save(String username, String password, String email) {
        return accountDao.save(username, password, email);
    }
}
