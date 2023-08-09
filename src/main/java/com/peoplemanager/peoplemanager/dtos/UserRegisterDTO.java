package com.peoplemanager.peoplemanager.dtos;

import com.peoplemanager.peoplemanager.enums.UserRole;

public record UserRegisterDTO(String password, String email, UserRole role) {
}
