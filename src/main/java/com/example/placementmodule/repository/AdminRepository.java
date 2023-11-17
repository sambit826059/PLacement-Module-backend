package com.example.placementmodule.repository;

import com.example.placementmodule.model.Admin;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AdminRepository extends JpaRepository<Admin, Long> {
    // You can add custom queries or methods if needed
}