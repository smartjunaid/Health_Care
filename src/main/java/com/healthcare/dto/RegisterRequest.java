package com.healthcare.dto;

import lombok.Data;

@Data
public class RegisterRequest {
    private String username;
    private String password;
    private String city;
    private String state;
    private String country;
}
