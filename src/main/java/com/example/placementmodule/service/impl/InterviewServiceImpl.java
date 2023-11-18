// InterviewServiceImpl.java
package com.example.placementmodule.service.impl;

import com.example.placementmodule.model.Interview;
import com.example.placementmodule.repository.InterviewRepository;
import com.example.placementmodule.service.InterviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class InterviewServiceImpl implements InterviewService {

    private final InterviewRepository interviewRepository;

    @Autowired
    public InterviewServiceImpl(InterviewRepository interviewRepository) {
        this.interviewRepository = interviewRepository;
    }

    @Override
    public List<Interview> getAllInterviews() {
        return interviewRepository.findAll();
    }

    @Override
    public Optional<Interview> getInterviewById(Long id) {
        return interviewRepository.findById(id);
    }

    @Override
    public Interview createInterview(Interview interview) {
        return interviewRepository.save(interview);
    }

    @Override
    public Interview updateInterview(Long id, Interview updatedInterview) {
        Optional<Interview> existingInterview = interviewRepository.findById(id);

        if (existingInterview.isPresent()) {
            Interview interview = existingInterview.get();
            // Update the fields you want to update
            if (updatedInterview.getInterviewType() != null) {
                interview.setInterviewType(updatedInterview.getInterviewType());
            }

            if (updatedInterview.getInterviewDate() != null) {
                interview.setInterviewDate(updatedInterview.getInterviewDate());
            }

            if (updatedInterview.getInterviewTime() != null) {
                interview.setInterviewTime(updatedInterview.getInterviewTime());
            }

            if (updatedInterview.getInterviewerName() != null) {
                interview.setInterviewerName(updatedInterview.getInterviewerName());
            }

            // ... update other fields as needed

            return interviewRepository.save(interview);
        } else {
            // Handle the case where the Interview with the given id is not found
            return null; // You can throw an exception or handle it as appropriate for your application
        }
    }

    @Override
    public void deleteInterview(Long id) {
        interviewRepository.deleteById(id);
    }
}
