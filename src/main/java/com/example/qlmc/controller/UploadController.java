package com.example.qlmc.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.example.qlmc.entity.Res;
import com.example.qlmc.service.UploadService;
import java.io.File;
import java.io.IOException;
import java.security.GeneralSecurityException;

@RestController
public class UploadController {

    @Autowired
    private UploadService service;

    @PostMapping("/api/uploadToGoogleDrive")
    public Object handleFileUpload(@RequestParam("file") MultipartFile file) throws IOException, GeneralSecurityException {
        
        if (file.isEmpty()) {
            return "FIle is empty";
        }
        String originalFilename = file.getOriginalFilename();
        String suffix = "";
        if (originalFilename != null && originalFilename.contains(".")) {
            suffix = originalFilename.substring(originalFilename.lastIndexOf('.'));
        }
        File tempFile = File.createTempFile("vku", suffix);
        file.transferTo(tempFile);
        Res res = service.uploadImageToDrive(originalFilename, tempFile);
        System.out.println(res);
        return res;
    }
}