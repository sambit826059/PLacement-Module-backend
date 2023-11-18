// ApplicationServiceImpl.java
package com.example.placementmodule.service.impl;

import com.example.placementmodule.model.Application;
import com.example.placementmodule.repository.ApplicationRepository;
import com.example.placementmodule.service.ApplicationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ApplicationServiceImpl implements ApplicationService {

    private final ApplicationRepository applicationRepository;

    @Autowired
    public ApplicationServiceImpl(ApplicationRepository applicationRepository) {
        this.applicationRepository = applicationRepository;
    }

    @Override
    public List<Application> getAllApplications() {
        return applicationRepository.findAll();
    }

    @Override
    public Optional<Application> getApplicationById(Long id) {
        return applicationRepository.findById(id);
    }

    @Override
    public Application createApplication(Application application) {
        return applicationRepository.save(application);
    }

    @Override
    public Application updateApplication(Long id, Application updatedApplication) {
        Optional<Application> existingApplication = applicationRepository.findById(id);

        if (existingApplication.isPresent()) {
            Application application = existingApplication.get();
            // Update the fields you want to update
            if (updatedApplication.getStudentId() != null) {
                application.setStudentId(updatedApplication.getStudentId());
            }

            if (updatedApplication.getJobPostingId() != null) {
                application.setJobPostingId(updatedApplication.getJobPostingId());
            }

            if (updatedApplication.getStatus() != null) {
                application.setStatus(updatedApplication.getStatus());
            }

            // ... update other fields as needed

            return applicationRepository.save(application);
        } else {
            // Handle the case where the application with the given id is not found
            return null; // You can throw an exception or handle it as appropriate for your application
        }
    }

    @Override
    public void deleteApplication(Long id) {
        applicationRepository.deleteById(id);
    }
}
