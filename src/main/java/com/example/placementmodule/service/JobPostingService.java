package com.example.placementmodule.service;

import com.example.placementmodule.model.JobPosting;

import java.util.List;
import java.util.Optional;

public interface JobPostingService {
    List<JobPosting> getAllJobPostings();

    Optional<JobPosting> getJobPostingById(Long id);

    JobPosting createJobPosting(JobPosting jobPosting);

    JobPosting updateJobPosting(Long id, JobPosting updatedJobPosting);

    void deleteJobPosting(Long id);
}
