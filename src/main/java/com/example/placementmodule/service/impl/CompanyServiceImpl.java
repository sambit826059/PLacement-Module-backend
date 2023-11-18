// CompanyServiceImpl.java
package com.example.placementmodule.service.impl;

import com.example.placementmodule.model.Company;
import com.example.placementmodule.repository.CompanyRepository;
import com.example.placementmodule.service.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CompanyServiceImpl implements CompanyService {

    private final CompanyRepository companyRepository;

    @Autowired
    public CompanyServiceImpl(CompanyRepository companyRepository) {
        this.companyRepository = companyRepository;
    }

    @Override
    public List<Company> getAllCompanies() {
        return companyRepository.findAll();
    }

    @Override
    public Optional<Company> getCompanyById(Long id) {
        return companyRepository.findById(id);
    }

    @Override
    public Company createCompany(Company company) {
        return companyRepository.save(company);
    }

    @Override
    public Company updateCompany(Long id, Company updatedCompany) {
        Optional<Company> existingCompany = companyRepository.findById(id);

        if (existingCompany.isPresent()) {
            Company company = existingCompany.get();
            // Update the fields you want to update
            if (updatedCompany.getName() != null) {
                company.setName(updatedCompany.getName());
            }

            if (updatedCompany.getIndustry() != null) {
                company.setIndustry(updatedCompany.getIndustry());
            }

            if (updatedCompany.getLocation() != null) {
                company.setLocation(updatedCompany.getLocation());
            }

            // ... update other fields as needed

            return companyRepository.save(company);
        } else {
            // Handle the case where the company with the given id is not found
            return null; // You can throw an exception or handle it as appropriate for your application
        }
    }

    @Override
    public void deleteCompany(Long id) {
        companyRepository.deleteById(id);
    }
}
