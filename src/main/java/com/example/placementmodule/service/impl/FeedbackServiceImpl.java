// FeedbackServiceImpl.java
package com.example.placementmodule.service.impl;

import com.example.placementmodule.model.Feedback;
import com.example.placementmodule.repository.FeedbackRepository;
import com.example.placementmodule.service.FeedbackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FeedbackServiceImpl implements FeedbackService {

    private final FeedbackRepository feedbackRepository;

    @Autowired
    public FeedbackServiceImpl(FeedbackRepository feedbackRepository) {
        this.feedbackRepository = feedbackRepository;
    }

    @Override
    public List<Feedback> getAllFeedbacks() {
        return feedbackRepository.findAll();
    }

    @Override
    public Optional<Feedback> getFeedbackById(Long id) {
        return feedbackRepository.findById(id);
    }

    @Override
    public Feedback createFeedback(Feedback feedback) {
        return feedbackRepository.save(feedback);
    }

    @Override
    public Feedback updateFeedback(Long id, Feedback updatedFeedback) {
        Optional<Feedback> existingFeedback = feedbackRepository.findById(id);

        if (existingFeedback.isPresent()) {
            Feedback feedback = existingFeedback.get();
            // Update the fields you want to update
            if (updatedFeedback.getStudentId() != null) {
                feedback.setStudentId(updatedFeedback.getStudentId());
            }

            if (updatedFeedback.getCatagory() != null) {
                feedback.setCatagory(updatedFeedback.getCatagory());
            }

            if (updatedFeedback.getFeedbackText() != null) {
                feedback.setFeedbackText(updatedFeedback.getFeedbackText());
            }

            if (updatedFeedback.getRating() != 0) {
                feedback.setRating(updatedFeedback.getRating());
            }

            // ... update other fields as needed

            return feedbackRepository.save(feedback);
        } else {
            // Handle the case where the feedback with the given id is not found
            return null; // You can throw an exception or handle it as appropriate for your application
        }
    }

    @Override
    public void deleteFeedback(Long id) {
        feedbackRepository.deleteById(id);
    }
}
