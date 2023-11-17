package com.example.placementmodule.repository;

import com.example.placementmodule.model.Application;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ApplicationRepository extends JpaRepository<Application, Long> {
    // You can add custom queries or methods if needed
}
