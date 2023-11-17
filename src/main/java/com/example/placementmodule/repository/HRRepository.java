package com.example.placementmodule.repository;

import com.example.placementmodule.model.HR;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HRRepository extends JpaRepository<HR, Long> {
    // You can add custom queries or methods if needed
}