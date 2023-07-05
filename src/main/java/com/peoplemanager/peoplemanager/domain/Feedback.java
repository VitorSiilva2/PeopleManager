package com.peoplemanager.peoplemanager.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.time.Instant;
import java.util.Objects;
import java.util.UUID;

@Component
@Entity
@Table(name = "TB_FEEDBACKS")
public class Feedback implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;
    private String FeedbackText;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss'Z'", timezone = "GMT")
    private Instant moment;

    @ManyToOne
    @JoinColumn(name = "collaborator_id")
    private Collaborator CollaboratorId;

    public Feedback() {
    }

    public Feedback(UUID id, String feedbackText, Instant moment, Collaborator collaboratorId) {
        this.id = id;
        FeedbackText = feedbackText;
        this.moment = moment;
        CollaboratorId = collaboratorId;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public Collaborator getCollaboratorId() {
        return CollaboratorId;
    }

    public void setCollaboratorId(Collaborator collaboratorId) {
        CollaboratorId = collaboratorId;
    }

    public String getFeedbackText() {
        return FeedbackText;
    }

    public void setFeedbackText(String feedbackText) {
        FeedbackText = feedbackText;
    }

    @Override
    public String toString() {
        return "Feedback{" +
                "id=" + id +
                ", FeedbackText='" + FeedbackText + '\'' +
                ", moment=" + moment +
                ", CollaboratorId=" + CollaboratorId +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Feedback feedback)) return false;
        return id.equals(feedback.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
