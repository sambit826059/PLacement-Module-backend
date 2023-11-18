// AdminService.java
package com.example.placementmodule.service;

import com.example.placementmodule.model.Admin;

import java.util.List;
import java.util.Optional;

public interface AdminService {
    List<Admin> getAllAdmins();

    Optional<Admin> getAdminById(Long id);

    Admin createAdmin(Admin admin);

    Admin updateAdmin(Long id, Admin updatedAdmin);

    void deleteAdmin(Long id);
}
