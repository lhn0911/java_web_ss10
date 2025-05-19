package com.rikkei.ss10.service;


import com.rikkei.ss10.model.Account;

public interface AccountService {
    boolean save(String username, String password, String email);
}
