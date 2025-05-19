package com.rikkei.ss10.controller;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import com.rikkei.ss10.model.Document;
import com.rikkei.ss10.model.Project;
import com.rikkei.ss10.service.ProjectService;
import com.rikkei.ss10.service.DocumentService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/project")
public class ProjectController {

    @Autowired
    private ProjectService projectService;

    @Autowired
    private DocumentService documentService;

    @Autowired
    private Cloudinary cloudinary;

    @GetMapping("/form")
    public String showForm(Model model) {
        model.addAttribute("project", new Project());
        return "projectForm";
    }

    @PostMapping("/create")
    public String createProject(@ModelAttribute Project project,
                                @RequestParam("documents[0].file") List<MultipartFile> files) {
        List<Document> savedDocuments = new ArrayList<>();

        for (MultipartFile file : files) {
            if (!file.isEmpty()) {
                try {
                    Map uploadResult = cloudinary.uploader().upload(file.getBytes(),
                            ObjectUtils.asMap("resource_type", "auto"));

                    String fileUrl = uploadResult.get("secure_url").toString();

                    Document doc = new Document();
                    doc.setTitle(file.getOriginalFilename());
                    doc.setDescription("Uploaded via form"); // có thể lấy từ form nếu cần
                    doc.setUrl(fileUrl);
                    doc.setProject(project); // gán project vào document

                    documentService.save(doc);
                    savedDocuments.add(doc);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        project.setDocuments(savedDocuments);

        projectService.save(project);

        return "redirect:/project/success";
    }

    @PostMapping("/update")
    public String updateProject(@ModelAttribute Project project) {
        projectService.update(project);
        return "redirect:/project/success";
    }

    @PostMapping("/delete")
    public String deleteProject(@RequestParam("id") Long id) {
        projectService.deleteById(id);
        return "redirect:/project/success";
    }

    @GetMapping("/success")
    public String showSuccess() {
        return "success";
    }
}
