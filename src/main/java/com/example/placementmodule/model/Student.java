package com.example.placementmodule.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Student {
    @Id
    private Long id;
    private Integer registrationNumber;
    private String firstName;
    private String middleName;
    private String lastName;
    private String email;
}
