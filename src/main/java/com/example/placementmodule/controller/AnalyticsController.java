package com.example.placementmodule.controller;

import com.example.placementmodule.model.PlacementAnalytics;
import com.example.placementmodule.repository.PlacementAnalyticsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/analytics")
public class AnalyticsController {
    @Autowired
    private PlacementAnalyticsRepository analyticsRepository;

    @GetMapping("/student/{studentId}")
    public ResponseEntity<List<PlacementAnalytics>> getAnalyticsByStudent(@PathVariable Long studentId) {
        List<PlacementAnalytics> analytics = analyticsRepository.findByStudentId(studentId);
        return ResponseEntity.ok(analytics);
    }

    @PostMapping
    public ResponseEntity<String> addAnalytics(@RequestBody PlacementAnalytics analytics) {
        analyticsRepository.save(analytics);
        return ResponseEntity.ok("Analytics data added successfully");
    }

    // Add other analytics-related functionalities as needed
}
