package com.rikkei.ss10.controller;

import com.rikkei.ss10.model.Document;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

@Controller
public class DocumentController {

    @GetMapping("/upload")
    public String showForm(Model model) {
        model.addAttribute("document", new Document());
        return "documentForm";
    }

    @PostMapping("/upload")
    public String uploadDocument(@ModelAttribute("document") Document document, Model model) {
        MultipartFile file = document.getFile();

        if (!file.isEmpty()) {
            try {
                String uploadDir = "uploads/";
                File dir = new File(uploadDir);
                if (!dir.exists()) dir.mkdirs();

                String filePath = uploadDir + file.getOriginalFilename();
                file.transferTo(new File(filePath));

                System.out.println("Title: " + document.getTitle());
                System.out.println("Description: " + document.getDescription());
                System.out.println("Saved to: " + filePath);

                model.addAttribute("message", "Upload thành công!");

            } catch (IOException e) {
                e.printStackTrace();
                model.addAttribute("message", "Upload thất bại!");
            }
        } else {
            model.addAttribute("message", "File rỗng!");
        }

        return "documentForm";
    }
}