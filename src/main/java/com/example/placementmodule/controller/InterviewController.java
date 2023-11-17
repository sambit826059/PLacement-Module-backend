package com.example.placementmodule.controller;

import com.example.placementmodule.model.Interview;
import com.example.placementmodule.repository.InterviewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/interview")
public class InterviewController {
    @Autowired
    private InterviewRepository interviewRepository;

    @PostMapping
    public ResponseEntity<String> scheduleInterview(@RequestBody Interview interview) {
        interviewRepository.save(interview);
        return ResponseEntity.ok("Interview scheduled successfully");
    }

    // Add other interview-related functionalities as needed
}
