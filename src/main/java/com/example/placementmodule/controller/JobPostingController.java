package com.example.placementmodule.controller;

import com.example.placementmodule.model.JobPosting;
import com.example.placementmodule.repository.JobPostingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
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
    public ResponseEntity<String> createJobPosting(
            @ModelAttribute JobPosting jobPosting,
            @RequestParam("file") MultipartFile file) {
        try {
            // Check if the file is not empty
            if (file.isEmpty()) {
                return ResponseEntity.badRequest().body("Please provide a file");
            }

            // Validate file type (can be customized this based on requirements)
            String contentType = file.getContentType();
            if (contentType == null || !contentType.startsWith("image")) {
                return ResponseEntity.badRequest().body("Invalid file type. Please upload an image");
            }

            // Process the file and save it to a predefined directory
            Path uploadDir = Paths.get("src", "main", "resources", "static", "uploads");
            String fileName = System.currentTimeMillis() + "_" + file.getOriginalFilename();
            Path filePath = uploadDir.resolve(fileName);

            // Create the directory if it does not exist

            if (!Files.exists(uploadDir)) {
                Files.createDirectories(uploadDir);
            }

            // Save the file to the server
            file.transferTo(filePath.toFile());

            // Set the file URL or any relevant information in the jobPosting
            jobPosting.setCompanyLogoUrl("/uploads/" + fileName);

            // Save the job posting along with the file information
            jobPostingRepository.save(jobPosting);

            return ResponseEntity.status(HttpStatus.CREATED).body("Job posting created");
        } catch (IOException e) {
            // Handle the exception (e.g., log it)
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error creating job posting");
        }
    }


}