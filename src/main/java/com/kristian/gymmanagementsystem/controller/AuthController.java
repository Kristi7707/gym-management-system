package com.kristian.gymmanagementsystem.controller;

import com.kristian.gymmanagementsystem.security.JwtUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {

    private final JwtUtil jwtUtil;
    private final PasswordEncoder passwordEncoder;

    private final String ADMIN_USERNAME = "Egla";
    private final String ADMIN_PASSWORD_HASH = "$2a$10$AhXXHVW4pEmkO0Ql6VeyI.mEOJh1SWIYvag0ra7EmZyxCcJLsHwxW";

    @GetMapping("/hash")
    public String hash() {
        return passwordEncoder.encode("Ladiesgym28");
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody Map<String, String> credentials) {
        String username = credentials.get("username");
        String password = credentials.get("password");



        if (ADMIN_USERNAME.equals(username) && passwordEncoder.matches(password, ADMIN_PASSWORD_HASH)) {
            String token = jwtUtil.generateToken(username);
            return ResponseEntity.ok(Map.of("token", token));
        }



        return ResponseEntity.status(401).body(Map.of("error", "Invalid credentials"));
    }
}