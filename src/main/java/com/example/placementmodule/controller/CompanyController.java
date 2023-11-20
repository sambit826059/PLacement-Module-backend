package com.example.placementmodule.controller;

import com.example.placementmodule.model.Company;
import com.example.placementmodule.repository.CompanyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/company")
public class CompanyController {
    @Autowired
    private CompanyRepository companyRepository;

    @PostMapping
    public ResponseEntity<String> createCompany(@RequestBody Company company) {
        companyRepository.save(company);
        return ResponseEntity.ok("Company created successfully");
    }

    // Add other company-related functionalities as needed
}
