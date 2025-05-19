package com.rikkei.ss10.controller;

import com.rikkei.ss10.model.Product;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class ProductController {

    @GetMapping("/product")
    public String showForm(Model model) {
        model.addAttribute("product", new Product());
        return "productForm";
    }

    @PostMapping("/add")
    public String addProduct(@ModelAttribute Product product, Model model) {
        model.addAttribute("product", product);
        return "productResult";
    }
}

