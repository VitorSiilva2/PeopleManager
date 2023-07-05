package com.peoplemanager.peoplemanager.controllers;

import com.peoplemanager.peoplemanager.domain.Collaborator;
import com.peoplemanager.peoplemanager.domain.User;
import com.peoplemanager.peoplemanager.services.CollaboratorService;
import com.peoplemanager.peoplemanager.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping(value = "/collaborators")
public class CollaboratorController {

    @Autowired
    private CollaboratorService collaboratorService;

    @GetMapping
    public ResponseEntity<List<Collaborator>> findAll() {
        List<Collaborator> list = collaboratorService.findAll();
        return ResponseEntity.ok().body(list);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Collaborator> findById(@PathVariable UUID id) {
        Collaborator obj = collaboratorService.findById(id);
        return ResponseEntity.ok().body(obj);
    }

    @PostMapping()
    public ResponseEntity<Collaborator> addCollaborator(@RequestBody Collaborator collaborator) {
        collaboratorService.addCollaborator(collaborator);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(collaborator.getId()).toUri();
        return ResponseEntity.created(uri).body(collaborator);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> deleteCollaborator(@PathVariable UUID id) {
        collaboratorService.deleteCollaborator(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<Collaborator> updateCollaborator(@PathVariable UUID id, @RequestBody Collaborator obj) {
        obj = collaboratorService.updateCollaborator(id, obj);
        return ResponseEntity.ok().body(obj);
    }


}
