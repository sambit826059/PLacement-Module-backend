// CompanyService.java
package com.example.placementmodule.service;

import com.example.placementmodule.model.Company;

import java.util.List;
import java.util.Optional;

public interface CompanyService {
    List<Company> getAllCompanies();

    Optional<Company> getCompanyById(Long id);

    Company createCompany(Company company);

    Company updateCompany(Long id, Company updatedCompany);

    void deleteCompany(Long id);
}
