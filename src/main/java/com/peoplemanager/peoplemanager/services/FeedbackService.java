package com.peoplemanager.peoplemanager.services;

import com.peoplemanager.peoplemanager.domain.Feedback;
import com.peoplemanager.peoplemanager.domain.User;
import com.peoplemanager.peoplemanager.repositories.FeedbackRepository;
import com.peoplemanager.peoplemanager.repositories.UserRepository;
import com.peoplemanager.peoplemanager.services.exceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class FeedbackService {
    @Autowired
    private FeedbackRepository feedbackRepository;

    public List<Feedback> findAll() {
        return feedbackRepository.findAll();
    }

    public Feedback findById(UUID id) {
        Optional<Feedback> obj = feedbackRepository.findById(id);
        return obj.orElseThrow(() -> new ResourceNotFoundException(id));
    }

    public Feedback addFeedBack(Feedback feedback) {
        return feedbackRepository.save(feedback);
    }

    public void deleteFeedback(UUID id) {
        feedbackRepository.deleteById(id);
    }

    public Feedback updateFeedback(UUID id, Feedback obj) {
        Feedback feedback = feedbackRepository.getReferenceById(id);
        updateData(feedback, obj);
        return feedbackRepository.save(feedback);

    }

    private void updateData(Feedback feedback, Feedback obj) {
        feedback.setFeedbackText(obj.getFeedbackText());
    }

}
