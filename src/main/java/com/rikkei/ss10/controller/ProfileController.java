package com.rikkei.ss10.controller;

import com.rikkei.ss10.model.UserProfile;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

@Controller
public class ProfileController {

    private static final String UPLOAD_DIR = "D:/uploads/";

    @GetMapping("/upload-form")
    public String showForm(Model model) {
        model.addAttribute("userProfile", new UserProfile());
        return "uploadForm";
    }

    @PostMapping("/upload-avatar")
    public String uploadAvatar(@ModelAttribute("userProfile") UserProfile userProfile, Model model) {
        MultipartFile file = userProfile.getAvatar();
        String username = userProfile.getUsername();

        if (!file.isEmpty()) {
            try {
                File uploadDir = new File(UPLOAD_DIR);
                if (!uploadDir.exists()) {
                    uploadDir.mkdirs();
                }

                String fileName = System.currentTimeMillis() + "_" + file.getOriginalFilename();
                String filePath = UPLOAD_DIR + fileName;
                file.transferTo(new File(filePath));

                model.addAttribute("message", "Upload thành công!");
                model.addAttribute("username", username);
                model.addAttribute("avatarPath", "/uploads/" + fileName);
            } catch (IOException e) {
                e.printStackTrace();
                model.addAttribute("message", "Upload thất bại!");
            }
        } else {
            model.addAttribute("message", "Vui lòng chọn file!");
        }

        return "uploadResult";
    }
}
