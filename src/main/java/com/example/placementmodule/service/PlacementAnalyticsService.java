// PlacementAnalyticsService.java
package com.example.placementmodule.service;

import com.example.placementmodule.model.PlacementAnalytics;

import java.util.List;
import java.util.Optional;

public interface PlacementAnalyticsService {
    List<PlacementAnalytics> getAllPlacementAnalytics();

    Optional<PlacementAnalytics> getPlacementAnalyticsById(Long id);

    PlacementAnalytics createPlacementAnalytics(PlacementAnalytics placementAnalytics);

    PlacementAnalytics updatePlacementAnalytics(Long id, PlacementAnalytics updatedPlacementAnalytics);

    void deletePlacementAnalytics(Long id);
}
