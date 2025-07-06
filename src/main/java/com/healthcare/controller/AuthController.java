package com.healthcare.controller;

import com.healthcare.dto.LoginRequest;
import com.healthcare.dto.RegisterRequest;
import com.healthcare.entity.*;
import com.healthcare.repository.*;
import com.healthcare.security.JwtUtil;
import com.healthcare.service.CustomUserDetailsService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.*;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    @Autowired
    private AuthenticationManager authManager;

    @Autowired
    private JwtUtil jwtUtil;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private UserRepository userRepo;

    @Autowired
    private CityRepository cityRepo;

    @Autowired
    private StateRepository stateRepo;

    @Autowired
    private CountryRepository countryRepo;

    @PostMapping("/login")
    public String login(@RequestBody LoginRequest request) {
        authManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        request.getUsername(), request.getPassword()));
        String token = jwtUtil.generateToken(request.getUsername());
        return "Bearer " + token;
    }

    @PostMapping("/register")
    public String register(@RequestBody RegisterRequest request) {
        if (userRepo.findByUsername(request.getUsername()).isPresent()) {
            return "Username already exists!";
        }

        City city = cityRepo.findById(request.getCity()).orElse(null);
        State state = stateRepo.findById(request.getState()).orElse(null);
        Country country = countryRepo.findById(request.getCountry()).orElse(null);

        if (city == null || state == null || country == null) {
            return "Invalid city/state/country. Please check master data.";
        }

        User user = new User();
        user.setUsername(request.getUsername());
        user.setPassword(passwordEncoder.encode(request.getPassword()));
        user.setCity(city);
        user.setState(state);
        user.setCountry(country);

        userRepo.save(user);

        return "User registered successfully!";
    }
}
