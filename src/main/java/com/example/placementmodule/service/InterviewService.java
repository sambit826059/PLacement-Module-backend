// InterviewService.java
package com.example.placementmodule.service;

import com.example.placementmodule.model.Interview;

import java.util.List;
import java.util.Optional;

public interface InterviewService {
    List<Interview> getAllInterviews();

    Optional<Interview> getInterviewById(Long id);

    Interview createInterview(Interview interview);

    Interview updateInterview(Long id, Interview updatedInterview);

    void deleteInterview(Long id);
}
