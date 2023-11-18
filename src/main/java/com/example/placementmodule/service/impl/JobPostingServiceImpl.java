package com.example.placementmodule.service.impl;

import com.example.placementmodule.model.JobPosting;
import com.example.placementmodule.repository.JobPostingRepository;
import com.example.placementmodule.service.JobPostingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class JobPostingServiceImpl implements JobPostingService {

    private final JobPostingRepository jobPostingRepository;

    @Autowired
    public JobPostingServiceImpl(JobPostingRepository jobPostingRepository) {
        this.jobPostingRepository = jobPostingRepository;
    }

    @Override
    public List<JobPosting> getAllJobPostings() {
        return jobPostingRepository.findAll();
    }

    @Override
    public Optional<JobPosting> getJobPostingById(Long id) {
        return jobPostingRepository.findById(id);
    }

    @Override
    public JobPosting createJobPosting(JobPosting jobPosting) {
        return jobPostingRepository.save(jobPosting);
    }

    @Override
    public JobPosting updateJobPosting(Long id, JobPosting updatedJobPosting) {
        // Check if the job posting with the given id exists
        Optional<JobPosting> existingJobPosting = jobPostingRepository.findById(id);

        if (existingJobPosting.isPresent()) {
            JobPosting jobPosting = existingJobPosting.get();

            // Update the fields you want to update
            if (updatedJobPosting.getTitle() != null) {
                jobPosting.setTitle(updatedJobPosting.getTitle());
            }

            if (updatedJobPosting.getDescription() != null) {
                jobPosting.setDescription(updatedJobPosting.getDescription());
            }

            if (updatedJobPosting.getEmploymentType() != null) {
                jobPosting.setEmploymentType(updatedJobPosting.getEmploymentType());
            }

            // ... update other fields as needed

            return jobPostingRepository.save(jobPosting);
        } else {
            // Handle the case where the job posting with the given id is not found
            return null; // You can throw an exception or handle it as appropriate for your application
        }
    }


    @Override
    public void deleteJobPosting(Long id) {
        jobPostingRepository.deleteById(id);
    }
}
