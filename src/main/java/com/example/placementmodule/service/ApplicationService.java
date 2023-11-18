// ApplicationService.java
package com.example.placementmodule.service;

import com.example.placementmodule.model.Application;

import java.util.List;
import java.util.Optional;

public interface ApplicationService {
    List<Application> getAllApplications();

    Optional<Application> getApplicationById(Long id);

    Application createApplication(Application application);

    Application updateApplication(Long id, Application updatedApplication);

    void deleteApplication(Long id);
}
