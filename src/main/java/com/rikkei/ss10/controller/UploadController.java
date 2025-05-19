package com.rikkei.ss10.controller;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import com.rikkei.ss10.model.UploadFile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Map;

@Controller
public class UploadController {

    @Autowired
    private Cloudinary cloudinary;

    @GetMapping("/uploadB6")
    public String showUploadForm(Model model) {
        model.addAttribute("uploadFile", new UploadFile());
        return "uploadFormB6";
    }

    @PostMapping("/uploadB6")
    public String uploadFile(@ModelAttribute UploadFile uploadFile, Model model) {
        MultipartFile file = uploadFile.getFile();

        if (!file.isEmpty()) {
            try {
                Map uploadResult = cloudinary.uploader().upload(
                        file.getBytes(),
                        ObjectUtils.emptyMap()
                );

                String url = uploadResult.get("url").toString();
                System.out.println("Uploaded file URL: " + url);

                System.out.println("Description: " + uploadFile.getDescription());

                model.addAttribute("message", "Upload thành công!");
                model.addAttribute("fileUrl", url);
                model.addAttribute("description", uploadFile.getDescription());

            } catch (IOException e) {
                e.printStackTrace();
                model.addAttribute("message", "Upload thất bại!");
            }
        } else {
            model.addAttribute("message", "Vui lòng chọn file!");
        }

        return "uploadFormB6";
    }
}
