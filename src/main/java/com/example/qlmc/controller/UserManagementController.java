package com.example.qlmc.controller;

import com.example.qlmc.repository.UsersRepository;
import com.example.qlmc.service.JWTUtils;
import com.example.qlmc.service.TokenBlacklistService;
import com.fasterxml.jackson.databind.JsonNode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import com.example.qlmc.dto.ReqRes;
import com.example.qlmc.entity.User;
import com.example.qlmc.service.UsersManagementService;
import org.springframework.web.multipart.MultipartFile;

import java.util.Map;
import java.util.Optional;


@RestController
public class UserManagementController {
    @Autowired
    private UsersManagementService usersManagementService;
    @Autowired
    private JWTUtils jwtUtils;
    @Autowired
    private UsersRepository usersRepo;

    @GetMapping("/auth/isAccept")
    public Boolean checkIsAccept(@RequestHeader("Authorization") String authHeader) {
        if (authHeader != null && authHeader.startsWith("Bearer ")) {
            String userEmail = jwtUtils.extractUsername(authHeader.substring(7));
            Optional<User> userOptional = usersRepo.findByEmail(userEmail);
            if(userOptional.isEmpty()) {
                return false;
            }else{
                if(userOptional.get().getAccept() == 0) {
                    return false;
                }else{
                    return true;
                }
            }
        }
        return false;
    }
    @PostMapping("/auth/register")
        public ResponseEntity<Boolean> regeister(@RequestBody JsonNode formData) {
        return ResponseEntity.ok(usersManagementService.register(formData));
    }

    @PostMapping("/auth/login")
    public ResponseEntity<ReqRes> login(@RequestBody ReqRes req){
        return ResponseEntity.ok(usersManagementService.login(req));
    }

    @PostMapping("/auth/refresh")
    public ResponseEntity<ReqRes> refreshToken(@RequestBody ReqRes req){
        return ResponseEntity.ok(usersManagementService.refreshToken(req));
    }

    @GetMapping("/admin/get-all-users")
    public ResponseEntity<ReqRes> getAllUsers(){
        return ResponseEntity.ok(usersManagementService.getAllUsers());

    }

    @GetMapping("/admin/get-users/{userId}")
    public ResponseEntity<ReqRes> getUSerByID(@PathVariable Integer userId){
        return ResponseEntity.ok(usersManagementService.getUsersById(userId));

    }

    @PutMapping("/admin/update")
    public ResponseEntity<String> updateUser(@RequestBody JsonNode formData){
        ;
        return ResponseEntity.ok(usersManagementService.updateUser(formData));
    }

    @GetMapping("/adminuser/get-profile")
    public ResponseEntity<ReqRes> getMyProfile(){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String email = authentication.getName();
        ReqRes response = usersManagementService.getMyInfo(email);
        return  ResponseEntity.status(response.getStatusCode()).body(response);
    }

    @DeleteMapping("/admin/delete/{userId}")
    public ResponseEntity<ReqRes> deleteUSer(@PathVariable Integer userId){
        return ResponseEntity.ok(usersManagementService.deleteUser(userId));
    }


}