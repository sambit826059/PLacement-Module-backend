package com.example.placementmodule.service;

import com.example.placementmodule.model.PlacementAnalytics;
import com.example.placementmodule.repository.PlacementAnalyticsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AnalyticsService {

    @Autowired
    private PlacementAnalyticsRepository placementAnalyticsRepository;

    public List<PlacementAnalytics> getAllAnalytics() {
        return placementAnalyticsRepository.findAll();
    }

    public Optional<PlacementAnalytics> getAnalyticsById(Long id) {
        return placementAnalyticsRepository.findById(id);
    }

    public PlacementAnalytics createAnalytics(PlacementAnalytics analytics) {
        return placementAnalyticsRepository.save(analytics);
    }

    public void deleteAnalytics(Long id) {
        placementAnalyticsRepository.deleteById(id);
    }

    // Add more methods as needed
}
