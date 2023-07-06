package com.peoplemanager.peoplemanager.controllers;

import com.peoplemanager.peoplemanager.domain.User;
import com.peoplemanager.peoplemanager.dtos.UserRecordDto;
import com.peoplemanager.peoplemanager.services.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "/users")
public class UserController {

    @Autowired
    private UserService userService;
    private UserRecordDto userRecordDto;

    @GetMapping
    public ResponseEntity<List<UserRecordDto>> findAll() {
        List<UserRecordDto> listDTO = userService.findAll()
                .stream().map(user -> new UserRecordDto(user.getName(), user.getEmail()))
                .collect(Collectors.toList());
        return ResponseEntity.ok().body(listDTO);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<UserRecordDto> findById(@PathVariable @Valid UUID id) {
        User obj = userService.findById(id);
        userRecordDto = new UserRecordDto(obj.getName().toString(), obj.getEmail());
        return ResponseEntity.ok().body(userRecordDto);
    }

    @PostMapping()
    public ResponseEntity<User> addUser(@RequestBody User user) {
        userService.addUser(user);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(user.getId()).toUri();
        return ResponseEntity.created(uri).body(user);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable UUID id) {
        userService.deleteUser(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<User> updateUser(@PathVariable UUID id, @RequestBody User obj) {
        obj = userService.updateUser(id, obj);
        return ResponseEntity.ok().body(obj);
    }


}
