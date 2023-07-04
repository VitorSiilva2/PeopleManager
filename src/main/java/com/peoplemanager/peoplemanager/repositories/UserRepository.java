package com.peoplemanager.peoplemanager.repositories;

import com.peoplemanager.peoplemanager.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface UserRepository extends JpaRepository<User, UUID> {
}
