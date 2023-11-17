package com.example.placementmodule.controller;

import com.example.placementmodule.model.JobPosting;
import com.example.placementmodule.repository.JobPostingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/jobpostings")
public class JobPostingController {
    @Autowired
    private JobPostingRepository jobPostingRepository;

    @GetMapping
    public ResponseEntity<List<JobPosting>> getAllJobPostings() {
        List<JobPosting> jobPostings = jobPostingRepository.findAll();
        return ResponseEntity.ok(jobPostings);
    }

    @GetMapping("/{id}")
    public ResponseEntity<JobPosting> getJobPostingById(@PathVariable Long id) {
        // Retrieve job posting by ID
        Optional<JobPosting> jobPosting = jobPostingRepository.findById(id);

        if (jobPosting.isPresent()) {
            return ResponseEntity.ok(jobPosting.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public ResponseEntity<String> createJobPosting(@RequestBody JobPosting jobPosting) {
        jobPostingRepository.save(jobPosting);
        return ResponseEntity.status(HttpStatus.CREATED).body("Job posting created");
    }

}