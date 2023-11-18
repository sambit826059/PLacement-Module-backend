package com.example.placementmodule.repository;

import com.example.placementmodule.model.PlacementAnalytics;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PlacementAnalyticsRepository extends JpaRepository<PlacementAnalytics, Long> {
    List<PlacementAnalytics> findByStudentId(Long studentId);

    // Add other custom queries or methods as needed
}
