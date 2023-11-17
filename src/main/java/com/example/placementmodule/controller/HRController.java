package com.example.placementmodule.controller;

import com.example.placementmodule.model.HR;
import com.example.placementmodule.repository.HRRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/hr")
public class HRController {
    @Autowired
    private HRRepository hrRepository;

    @PostMapping
    public ResponseEntity<String> createHR(@RequestBody HR hr) {
        hrRepository.save(hr);
        return ResponseEntity.ok("HR person created successfully");
    }

    // Add other HR-related functionalities as needed
}