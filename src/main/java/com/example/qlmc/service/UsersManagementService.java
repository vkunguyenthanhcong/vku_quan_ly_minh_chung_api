package com.example.qlmc.service;


import java.util.HashMap;
import java.util.List;
import java.util.Optional;

import com.example.qlmc.controller.ImageUploadController;
import com.example.qlmc.entity.PhongBan;
import com.example.qlmc.repository.PhongBanRepository;
import com.fasterxml.jackson.databind.JsonNode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.qlmc.dto.ReqRes;
import com.example.qlmc.entity.User;
import com.example.qlmc.repository.UsersRepository;
import org.springframework.web.multipart.MultipartFile;

@Service
public class UsersManagementService {

    @Autowired
    private UsersRepository usersRepo;
    @Autowired
    private JWTUtils jwtUtils;
    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private PhongBanRepository phongBanRepository;
    @Autowired
    private ImageUploadController imageUploadController;

    public Boolean register(JsonNode json) {
        try {
            User ourUser = new User();
            ourUser.setEmail(json.get("email").asText());
            ourUser.setSdt(json.get("phone").asText());
            ourUser.setRole("USER");
            ourUser.setFullName(json.get("fullName").asText());

            ourUser.setPassword(passwordEncoder.encode(json.get("password").asText()));
            Optional<PhongBan> phongBanOptional = phongBanRepository.findById(json.get("idPhongBan").asInt());
            phongBanOptional.ifPresent(ourUser::setPhongBan);
            ourUser.setAvatar(json.get("avatar").asText());
            User savedUser = usersRepo.save(ourUser);
            if (savedUser.getId()>0) {
                return true;
            }

        }catch (Exception e){
            return false;
        }
        return false;
    }


    public ReqRes login(ReqRes loginRequest){
        ReqRes response = new ReqRes();
        try {
            authenticationManager
                    .authenticate(new UsernamePasswordAuthenticationToken(loginRequest.getEmail(),
                            loginRequest.getPassword()));
            var user = usersRepo.findByEmail(loginRequest.getEmail()).orElseThrow();
            var jwt = jwtUtils.generateToken(user);
            var refreshToken = jwtUtils.generateRefreshToken(new HashMap<>(), user);
            response.setStatusCode(200);
            response.setToken(jwt);
            response.setRole(user.getRole());
            response.setPhongBan(user.getPhongBan());
            response.setAvatar(user.getAvatar());
            response.setRefreshToken(refreshToken);
            response.setIsAccept(user.getIsAccept() == 1 ? true : false);
            response.setExpirationTime("24Hrs");
            response.setMessage("Successfully Logged In");

        }catch (Exception e){
            response.setStatusCode(500);
            response.setMessage(e.getMessage());
        }
        return response;
    }


    public ReqRes refreshToken(ReqRes refreshTokenReqiest){
        ReqRes response = new ReqRes();
        try{
            String ourEmail = jwtUtils.extractUsername(refreshTokenReqiest.getToken());
            User users = usersRepo.findByEmail(ourEmail).orElseThrow();
            if (jwtUtils.isTokenValid(refreshTokenReqiest.getToken(), users)) {
                var jwt = jwtUtils.generateToken(users);
                response.setStatusCode(200);
                response.setToken(jwt);
                response.setRefreshToken(refreshTokenReqiest.getToken());
                response.setExpirationTime("24Hr");
                response.setMessage("Successfully Refreshed Token");
            }
            response.setStatusCode(200);
            return response;

        }catch (Exception e){
            response.setStatusCode(500);
            response.setMessage(e.getMessage());
            return response;
        }
    }


    public ReqRes getAllUsers() {
        ReqRes reqRes = new ReqRes();
        try {
            List<User> result = usersRepo.findAll();
            if (!result.isEmpty()) {
                reqRes.setUserList(result);
                reqRes.setStatusCode(200);
                reqRes.setMessage("Successful");
            } else {
                reqRes.setStatusCode(404);
                reqRes.setMessage("No users found");
            }
            return reqRes;
        } catch (Exception e) {
            reqRes.setStatusCode(500);
            reqRes.setMessage("Error occurred: " + e.getMessage());
            return reqRes;
        }
    }


    public ReqRes getUsersById(Integer id) {
        ReqRes reqRes = new ReqRes();
        try {
            User usersById = usersRepo.findById(id).orElseThrow(() -> new RuntimeException("User Not found"));
            reqRes.setUser(usersById);
            reqRes.setStatusCode(200);
            reqRes.setMessage("Users with id '" + id + "' found successfully");
        } catch (Exception e) {
            reqRes.setStatusCode(500);
            reqRes.setMessage("Error occurred: " + e.getMessage());
        }
        return reqRes;
    }


    public ReqRes deleteUser(Integer userId) {
        ReqRes reqRes = new ReqRes();
        try {
            Optional<User> userOptional = usersRepo.findById(userId);
            if (userOptional.isPresent()) {
                usersRepo.deleteById(userId);
                reqRes.setStatusCode(200);
                reqRes.setMessage("User deleted successfully");
            } else {
                reqRes.setStatusCode(404);
                reqRes.setMessage("User not found for deletion");
            }
        } catch (Exception e) {
            reqRes.setStatusCode(500);
            reqRes.setMessage("Error occurred while deleting user: " + e.getMessage());
        }
        return reqRes;
    }

    public String updateUser(JsonNode formData) {
        ReqRes reqRes = new ReqRes();
        try {
            int userId = formData.get("id").asInt();
            Optional<User> userOptional = usersRepo.findById(userId);
            if (userOptional.isPresent()) {
                User existingUser = userOptional.get();
                PhongBan phongBan = phongBanRepository.findById(formData.get("idPhongBan").asInt()).orElse(null);
                existingUser.setPhongBan(phongBan);
                existingUser.setIsAccept(formData.get("isAccept").asBoolean() ? 1 : 0);

                User savedUser = usersRepo.save(existingUser);
                reqRes.setUser(savedUser);
                return ("OK");
            } else {
                return ("User Not found");
            }
        } catch (Exception e) {
            return ("User Not found");
        }

    }


    public ReqRes getMyInfo(String email){
        ReqRes reqRes = new ReqRes();
        try {
            Optional<User> userOptional = usersRepo.findByEmail(email);
            if (userOptional.isPresent()) {
                reqRes.setUser(userOptional.get());
                reqRes.setStatusCode(200);
                reqRes.setMessage("successful");
            } else {
                reqRes.setStatusCode(404);
                reqRes.setMessage("User not found for update");
            }

        }catch (Exception e){
            reqRes.setStatusCode(500);
            reqRes.setMessage("Error occurred while getting user info: " + e.getMessage());
        }
        return reqRes;

    }
}