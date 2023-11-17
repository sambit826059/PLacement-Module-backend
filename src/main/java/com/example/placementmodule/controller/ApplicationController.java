package com.example.placementmodule.controller;

import com.example.placementmodule.model.Application;
import com.example.placementmodule.repository.ApplicationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/application")
public class ApplicationController {
    @Autowired
    private ApplicationRepository applicationRepository;

    @PostMapping
    public ResponseEntity<String> submitApplication(@RequestBody Application application) {
        applicationRepository.save(application);
        return ResponseEntity.ok("Application submitted successfully");
    }

    // Add other application-related functionalities as needed
}
