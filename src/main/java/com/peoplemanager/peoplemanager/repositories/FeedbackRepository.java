package com.peoplemanager.peoplemanager.repositories;

import com.peoplemanager.peoplemanager.domain.Feedback;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface FeedbackRepository extends JpaRepository<Feedback, UUID> {
}
