package com.peoplemanager.peoplemanager.services;

import com.peoplemanager.peoplemanager.domain.User;
import com.peoplemanager.peoplemanager.repositories.UserRepository;
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
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public List<User> findAll() {
        return userRepository.findAll();
    }

    public User findById(UUID id) {
        Optional<User> obj = userRepository.findById(id);
        return obj.orElseThrow(() -> new ResourceNotFoundException(id));
    }

    public User addUser(User user) {
        return userRepository.save(user);
    }

    public void deleteUser(UUID id) {
        try {
            userRepository.deleteById(id);

        } catch (EmptyResultDataAccessException e) {
            throw new ResourceNotFoundException(id);
        } catch (DataIntegrityViolationException e) {
            throw new DatabaseException(e.getMessage());
        }
    }

    public User updateUser(UUID id, User obj) {
        try {
            User user = userRepository.getReferenceById(id);
            updateData(user, obj);
            return userRepository.save(user);
        } catch (EntityNotFoundException e) {
            throw new ResourceNotFoundException(id);
        }
    }

    private void updateData(User user, User obj) {

    }

}
