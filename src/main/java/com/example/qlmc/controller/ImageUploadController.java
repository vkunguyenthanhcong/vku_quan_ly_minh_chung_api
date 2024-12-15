package com.example.qlmc.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Base64;

@RestController
@RequestMapping("/api/images")
public class ImageUploadController {

    @Value("${upload.path}")
    private String uploadDir;

    @PostMapping("/upload")
    public ResponseEntity<?> uploadImage(@RequestParam("file") MultipartFile file) {
        try {
            // Dynamically determine the upload folder relative to the app's root directory
            String currentDir = System.getProperty("user.dir");
            Path uploadDir = Paths.get(currentDir, "uploads");

            // Ensure the directory exists
            if (!Files.exists(uploadDir)) {
                Files.createDirectories(uploadDir); // Create the directory
            }

            // Save the file in the uploads folder
            String fileName = System.currentTimeMillis() + "_" + file.getOriginalFilename();
            Path filePath = uploadDir.resolve(fileName);
            file.transferTo(filePath.toFile());

            String base64Image = convertImageToBase64(filePath.toFile());

            // Return the file URL (adjust as needed for frontend access)
            String fileUrl = "/uploads/" + fileName;
            return ResponseEntity.ok("data:image/png;base64," + base64Image);
        } catch (IOException e) {
            e.printStackTrace();
            return ResponseEntity.status(500).body("File upload failed: " + e.getMessage());
        }
    }

    private String convertImageToBase64(File file) throws IOException {
        // Create a byte array output stream to read the file into a byte array
        try (FileInputStream fileInputStream = new FileInputStream(file);
             ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream()) {

            byte[] buffer = new byte[1024];
            int length;
            while ((length = fileInputStream.read(buffer)) != -1) {
                byteArrayOutputStream.write(buffer, 0, length);
            }

            // Convert the byte array to Base64
            byte[] fileBytes = byteArrayOutputStream.toByteArray();
            return Base64.getEncoder().encodeToString(fileBytes);
        }
    }
}
