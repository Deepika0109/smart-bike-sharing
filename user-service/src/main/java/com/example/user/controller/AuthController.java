package com.example.user.controller;

import com.example.user.model.User;
import com.example.user.repo.UserRepository;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/auth")
public class AuthController {
    @Autowired private UserRepository repo;
    @Autowired private PasswordEncoder encoder;
    @Value("${jwt.secret}") private String secret;

    @PostMapping("/register")
    public User register(@RequestBody User u) {
        u.setUsername(u.getUsername());
        u.setPassword(encoder.encode(u.getPassword()));
        u.setRole("ROLE_USER");
        return repo.save(u);
    }

    @PostMapping("/login")
    public Map<String, String> login(@RequestBody Map<String, String> creds) {
        User u = repo.findByUsername(creds.get("username")).orElseThrow();
        if (!encoder.matches(creds.get("password"), u.getPassword())) {
            throw new RuntimeException("Invalid credentials");
        }
        String jwt = Jwts.builder()
                .setSubject(u.getUsername())
                .claim("roles", u.getRole())
                .signWith(SignatureAlgorithm.HS256, secret)
                .compact();
        return Map.of("token", jwt);
    }
}