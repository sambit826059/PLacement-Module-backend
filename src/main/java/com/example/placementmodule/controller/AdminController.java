package com.example.placementmodule.controller;

import com.example.placementmodule.model.Admin;
import com.example.placementmodule.repository.AdminRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/admins")
public class AdminController {
    @Autowired
    private AdminRepository adminRepository;

    @PostMapping
    public ResponseEntity<String> createAdmin(@RequestBody Admin admin) {
        adminRepository.save(admin);
        return ResponseEntity.ok("Admin created successfully");
    }

    // Add other admin-related functionalities as needed
}