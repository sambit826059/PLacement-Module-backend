package com.example.placementmodule.service;

import com.example.placementmodule.model.Admin;
import com.example.placementmodule.repository.AdminRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AdminService {

    @Autowired
    private AdminRepository adminRepository;

    public List<Admin> getAllAdmins() {
        return adminRepository.findAll();
    }

    public Optional<Admin> getAdminById(Long id) {
        return adminRepository.findById(id);
    }

    public Admin createAdmin(Admin admin) {
        return adminRepository.save(admin);
    }

    public void deleteAdmin(Long id) {
        adminRepository.deleteById(id);
    }

    // Add more methods as needed
}
