package com.example.qlmc.dto;

import java.util.List;

import com.example.qlmc.entity.PhongBan;
import com.example.qlmc.entity.User;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class ReqRes {

    private int statusCode;
    private String error;
    private String message;
    private String token;
    private String refreshToken;
    private String expirationTime;
    private String username;
    private String sdt;
    private String role;
    private String email;
    private String password;
    private PhongBan phongBan;
    private String avatar;
    private User user;
    private List<User> userList;
    private Boolean isAccept;
}