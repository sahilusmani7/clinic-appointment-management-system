package com.clinic.appointment.controller;

import com.clinic.appointment.dto.LoginRequest;
import com.clinic.appointment.dto.LoginResponse;
import com.clinic.appointment.entity.User;
import com.clinic.appointment.security.JwtUtil;
import com.clinic.appointment.service.UserService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthController {

    private final UserService userService;
    private final JwtUtil jwtUtil;

    public AuthController(UserService userService, JwtUtil jwtUtil) {
        this.userService = userService;
        this.jwtUtil = jwtUtil;
    }

    @PostMapping("/login")
    public LoginResponse login(@RequestBody LoginRequest request) {

        User user = userService.authenticate(
                request.getEmail(),
                request.getPassword()
        );

        String token = jwtUtil.generateToken(user.getEmail());
        return new LoginResponse(token);
    }
}
