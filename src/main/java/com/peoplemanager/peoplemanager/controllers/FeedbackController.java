package com.peoplemanager.peoplemanager.controllers;

import com.peoplemanager.peoplemanager.domain.Feedback;
import com.peoplemanager.peoplemanager.services.FeedbackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping(value = "/feedbacks")
public class FeedbackController {

    @Autowired
    private FeedbackService feedbackService;

    @GetMapping
    public ResponseEntity<List<Feedback>> findAll() {
        List<Feedback> list = feedbackService.findAll();
        return ResponseEntity.ok().body(list);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Feedback> findById(@PathVariable UUID id) {
        Feedback obj = feedbackService.findById(id);
        return ResponseEntity.ok().body(obj);
    }

    @GetMapping(value = "/collaborator/{id}")
    public ResponseEntity<List<Feedback>> findFeedbackById(@PathVariable UUID id) {
        List<Feedback> feedbacks = feedbackService.findFeedbackById(id);
        return ResponseEntity.ok().body(feedbacks);
    }

    @PostMapping()
    public ResponseEntity<Feedback> addFeedback(@RequestBody Feedback feedback) {
        feedbackService.addFeedBack(feedback);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(feedback.getId()).toUri();
        return ResponseEntity.created(uri).body(feedback);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> deleteFeedback(@PathVariable UUID id) {
       feedbackService.deleteFeedback(id);
       return ResponseEntity.noContent().build();
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<Feedback> updateFeedback(@PathVariable UUID id, @RequestBody Feedback obj) {
        obj = feedbackService.updateFeedback(id, obj);
        return ResponseEntity.ok().body(obj);
    }

}
