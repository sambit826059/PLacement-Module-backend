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
@RequestMapping("/jobpostings")
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
        try {
            // Validate jobPosting fields as needed
            if (jobPosting == null || jobPosting.getTitle() == null || jobPosting.getDescription() == null
                    || jobPosting.getCompany() == null || jobPosting.getEmploymentType() == null) {
                return ResponseEntity.badRequest().body("Please provide valid job posting data");
            }

            // Save the job posting
            jobPostingRepository.save(jobPosting);

            return ResponseEntity.status(HttpStatus.CREATED).body("Job posting created");
        } catch (Exception e) {
            // Handle the exception (e.g., log it)
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error creating job posting");
        }
    }



}