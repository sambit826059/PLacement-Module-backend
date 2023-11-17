package com.example.placementmodule.repository;

import com.example.placementmodule.model.Company;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CompanyRepository extends JpaRepository<Company, Long> {
    // You can add custom queries or methods if needed
}
