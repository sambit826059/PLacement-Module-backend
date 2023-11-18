// AdminServiceImpl.java
package com.example.placementmodule.service.impl;

import com.example.placementmodule.model.Admin;
import com.example.placementmodule.repository.AdminRepository;
import com.example.placementmodule.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AdminServiceImpl implements AdminService {

    private final AdminRepository adminRepository;

    @Autowired
    public AdminServiceImpl(AdminRepository adminRepository) {
        this.adminRepository = adminRepository;
    }

    @Override
    public List<Admin> getAllAdmins() {
        return adminRepository.findAll();
    }

    @Override
    public Optional<Admin> getAdminById(Long id) {
        return adminRepository.findById(id);
    }

    @Override
    public Admin createAdmin(Admin admin) {
        return adminRepository.save(admin);
    }

    @Override
    public Admin updateAdmin(Long id, Admin updatedAdmin) {
        Optional<Admin> existingAdmin = adminRepository.findById(id);

        if (existingAdmin.isPresent()) {
            Admin admin = existingAdmin.get();
            // Update the fields you want to update
            if (updatedAdmin.getUsername() != null) {
                admin.setUsername(updatedAdmin.getUsername());
            }

            if (updatedAdmin.getPassword() != null) {
                admin.setPassword(updatedAdmin.getPassword());
            }

            // ... update other fields as needed

            return adminRepository.save(admin);
        } else {
            // Handle the case where the admin with the given id is not found
            return null; // You can throw an exception or handle it as appropriate for your application
        }
    }

    @Override
    public void deleteAdmin(Long id) {
        adminRepository.deleteById(id);
    }
}
