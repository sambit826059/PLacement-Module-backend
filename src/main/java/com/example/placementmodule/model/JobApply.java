package com.example.placementmodule.model;


import javax.persistence.*;

public class JobApply {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String abc;
}
