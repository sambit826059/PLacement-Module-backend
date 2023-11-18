// PlacementAnalyticsServiceImpl.java
package com.example.placementmodule.service.impl;

import com.example.placementmodule.model.PlacementAnalytics;
import com.example.placementmodule.repository.PlacementAnalyticsRepository;
import com.example.placementmodule.service.PlacementAnalyticsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PlacementAnalyticsServiceImpl implements PlacementAnalyticsService {

    private final PlacementAnalyticsRepository placementAnalyticsRepository;

    @Autowired
    public PlacementAnalyticsServiceImpl(PlacementAnalyticsRepository placementAnalyticsRepository) {
        this.placementAnalyticsRepository = placementAnalyticsRepository;
    }

    @Override
    public List<PlacementAnalytics> getAllPlacementAnalytics() {
        return placementAnalyticsRepository.findAll();
    }

    @Override
    public Optional<PlacementAnalytics> getPlacementAnalyticsById(Long id) {
        return placementAnalyticsRepository.findById(id);
    }

    @Override
    public PlacementAnalytics createPlacementAnalytics(PlacementAnalytics placementAnalytics) {
        return placementAnalyticsRepository.save(placementAnalytics);
    }

    @Override
    public PlacementAnalytics updatePlacementAnalytics(Long id, PlacementAnalytics updatedPlacementAnalytics) {
        Optional<PlacementAnalytics> existingPlacementAnalytics = placementAnalyticsRepository.findById(id);

        if (existingPlacementAnalytics.isPresent()) {
            PlacementAnalytics placementAnalytics = existingPlacementAnalytics.get();
            // Update the fields you want to update
            if (updatedPlacementAnalytics.getStudentId() != null) {
                placementAnalytics.setStudentId(updatedPlacementAnalytics.getStudentId());
            }

            if (updatedPlacementAnalytics.getPlacementStatus() != null) {
                placementAnalytics.setPlacementStatus(updatedPlacementAnalytics.getPlacementStatus());
            }

            if (updatedPlacementAnalytics.getCompany() != null) {
                placementAnalytics.setCompany(updatedPlacementAnalytics.getCompany());
            }

            // ... update other fields as needed

            return placementAnalyticsRepository.save(placementAnalytics);
        } else {
            // Handle the case where the PlacementAnalytics with the given id is not found
            return null; // You can throw an exception or handle it as appropriate for your application
        }
    }

    @Override
    public void deletePlacementAnalytics(Long id) {
        placementAnalyticsRepository.deleteById(id);
    }
}
