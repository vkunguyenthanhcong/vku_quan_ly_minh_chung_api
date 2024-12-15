package com.example.qlmc.controller;

import com.example.qlmc.entity.PhongBan;
import com.example.qlmc.service.PhongBanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

@RestController
@RequestMapping("/public")
public class PublicController {
    @Autowired
    private PhongBanService phongBanService;

    @GetMapping("/phongban")
    public ResponseEntity<List<PhongBan>> getAllPhongBan(){
        return ResponseEntity.ok(phongBanService.getAllPhongBan());
    }
    @PostMapping("/upload/avatar")
    public String uploadImageToAvatar(@RequestParam("file") MultipartFile file) {
        try {
            // Dynamically determine the upload folder relative to the app's root directory
            String currentDir = System.getProperty("user.dir");
            Path uploadDir = Paths.get(currentDir, "uploads", "avatars");

            // Ensure the directory exists
            if (!Files.exists(uploadDir)) {
                Files.createDirectories(uploadDir); // Create the directory
            }

            // Save the file in the uploads folder
            String fileName = System.currentTimeMillis() + "_" + file.getOriginalFilename();
            Path filePath = uploadDir.resolve(fileName);
            file.transferTo(filePath.toFile());

            String fileUrl = "/uploads/avatars/" + fileName;
            return fileUrl;
        } catch (IOException e) {
            return e.getMessage();
        }
    }
}
