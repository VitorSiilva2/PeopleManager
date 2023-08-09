package com.peoplemanager.peoplemanager.enums;

public enum UserRole {
    ADMIN("admin"),
    USER("user");

    private String role;

    UserRole(String role){
        this.role = role;
    }

    private UserRole() {
    }

    public String getRole() {
        return role;
    }


}
