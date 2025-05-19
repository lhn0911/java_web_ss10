package com.rikkei.ss10.controller;

import com.rikkei.ss10.model.Account;
import com.rikkei.ss10.repository.AccountDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class AccountController {

    @Autowired
    private AccountDao accountDao;

    @GetMapping("/account")
    public String showForm(Model model) {
        model.addAttribute("account", new Account());
        return "registerForm";
    }

    @PostMapping("/register")
    public String register(@ModelAttribute Account account, Model model) {
        boolean isSaved = accountDao.save(account.getUsername(), account.getPassword(), account.getEmail());

        if (isSaved) {
            model.addAttribute("message", "Đăng ký tài khoản thành công!");
        } else {
            model.addAttribute("message", "Đăng ký thất bại. Vui lòng thử lại.");
        }

        model.addAttribute("account", account);
        return "accountResult";
    }

}
