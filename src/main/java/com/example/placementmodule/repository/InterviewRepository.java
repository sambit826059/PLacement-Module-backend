package com.example.placementmodule.repository;

import com.example.placementmodule.model.Interview;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InterviewRepository extends JpaRepository<Interview, Long> {
    // You can add custom queries or methods if needed
}
