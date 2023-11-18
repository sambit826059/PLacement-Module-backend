package com.example.placementmodule.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Notification {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long userId; // Id of the user receiving the notification
    private String message;
    private boolean read; // Indicates whether the notification has been read

    // Constructors, getters, setters
}
