// FeedbackService.java
package com.example.placementmodule.service;

import com.example.placementmodule.model.Feedback;

import java.util.List;
import java.util.Optional;

public interface FeedbackService {
    List<Feedback> getAllFeedbacks();

    Optional<Feedback> getFeedbackById(Long id);

    Feedback createFeedback(Feedback feedback);

    Feedback updateFeedback(Long id, Feedback updatedFeedback);

    void deleteFeedback(Long id);
}
