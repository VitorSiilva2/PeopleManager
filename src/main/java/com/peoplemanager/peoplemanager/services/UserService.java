package com.peoplemanager.peoplemanager.services;

import com.peoplemanager.peoplemanager.domain.User;
import com.peoplemanager.peoplemanager.repositories.UserRepository;
import com.peoplemanager.peoplemanager.services.exceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
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
        userRepository.deleteById(id);
    }

    public User updateUser(UUID id, User obj) {
        User user = userRepository.getReferenceById(id);
        updateData(user, obj);
        return userRepository.save(user);
    }

    private void updateData(User user, User obj) {
        user.setName(obj.getName());
        user.setEmail(obj.getEmail());

    }

}
