package com.example.placementmodule.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class PlacementAnalytics {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long studentId;
    private String placementStatus; // For example: Placed, Not Placed
    private String company;

    // Other relevant fields

    // Constructors, getters, setters
}
