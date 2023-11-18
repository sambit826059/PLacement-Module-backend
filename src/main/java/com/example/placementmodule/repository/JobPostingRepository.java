package com.example.placementmodule.repository;

import com.example.placementmodule.model.JobPosting;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface JobPostingRepository extends JpaRepository<JobPosting, Long> {

    List<JobPosting> findByEmploymentType(String employmentType);

}