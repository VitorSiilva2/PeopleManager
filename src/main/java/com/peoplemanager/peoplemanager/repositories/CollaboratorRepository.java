package com.peoplemanager.peoplemanager.repositories;

import com.peoplemanager.peoplemanager.domain.Collaborator;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface CollaboratorRepository extends JpaRepository<Collaborator, UUID> {
}
