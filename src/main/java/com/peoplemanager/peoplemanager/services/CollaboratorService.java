package com.peoplemanager.peoplemanager.services;

import com.peoplemanager.peoplemanager.domain.Collaborator;
import com.peoplemanager.peoplemanager.domain.Feedback;
import com.peoplemanager.peoplemanager.domain.User;
import com.peoplemanager.peoplemanager.repositories.CollaboratorRepository;
import com.peoplemanager.peoplemanager.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
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
        return obj.get();
    }

    public Collaborator addCollaborator(Collaborator collaborator) {
        return collaboratorRepository.save(collaborator);
    }

    public void deleteCollaborator(UUID id) {
        collaboratorRepository.deleteById(id);
    }

    public Collaborator updateCollaborator(UUID id, Collaborator obj) {
        Collaborator collaborator = collaboratorRepository.getReferenceById(id);
        updateData(collaborator, obj);
        return collaboratorRepository.save(collaborator);

    }

    private void updateData(Collaborator collaborator, Collaborator obj) {
        collaborator.setEmail(obj.getEmail());
        collaborator.setName(obj.getName());
        collaborator.setOffice(obj.getOffice());
    }
}
