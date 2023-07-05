package com.peoplemanager.peoplemanager.services;

import com.peoplemanager.peoplemanager.domain.Collaborator;
import com.peoplemanager.peoplemanager.repositories.CollaboratorRepository;
import com.peoplemanager.peoplemanager.services.exceptions.DatabaseException;
import com.peoplemanager.peoplemanager.services.exceptions.ResourceNotFoundException;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class CollaboratorService {
    @Autowired
    private CollaboratorRepository collaboratorRepository;

    public List<Collaborator> findAll() {
        return collaboratorRepository.findAll();
    }

    public Collaborator findById(UUID id) {
        Optional<Collaborator> obj = collaboratorRepository.findById(id);
        return obj.orElseThrow(() -> new ResourceNotFoundException(id));
    }

    public Collaborator addCollaborator(Collaborator collaborator) {
        return collaboratorRepository.save(collaborator);
    }

    public void deleteCollaborator(UUID id) {
        try {
            collaboratorRepository.deleteById(id);
        } catch (
                EmptyResultDataAccessException e) {
            throw new ResourceNotFoundException(id);
        } catch (
                DataIntegrityViolationException e) {
            throw new DatabaseException(e.getMessage());
        }

    }

    public Collaborator updateCollaborator(UUID id, Collaborator obj) {
        try {
            Collaborator collaborator = collaboratorRepository.getReferenceById(id);
            updateData(collaborator, obj);
            return collaboratorRepository.save(collaborator);
        } catch (EntityNotFoundException e) {
            throw new ResourceNotFoundException(id);
        }

    }

    private void updateData(Collaborator collaborator, Collaborator obj) {
        collaborator.setEmail(obj.getEmail());
        collaborator.setName(obj.getName());
        collaborator.setOffice(obj.getOffice());
    }
}
