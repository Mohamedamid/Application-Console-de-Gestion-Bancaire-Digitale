package com.gestionBank.service;

import com.gestionBank.model.User;
import com.gestionBank.repositorie.UserRepository;

import java.util.UUID;

public class AuthService {
    private final UserRepository userRepository;
    private User currentUser;

    public AuthService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public boolean register(String fullName, String email, String address, String password) {
        if (fullName == null || fullName.trim().isEmpty()) {
            throw new IllegalArgumentException("Username is null or empty");
        }

        if (email == null || email.trim().isEmpty()) {
            throw new IllegalArgumentException("Email is null or empty");
        }

        if (password == null || password.length() < 6) {
            throw new IllegalArgumentException("Password is less than 6 characters");
        }

        if (userRepository.existsByEmail(email)) {
            throw new IllegalArgumentException("Email already exists");
        }

        User user = new User(fullName.trim(), email.trim().toLowerCase(), address, password);
        userRepository.save(user);
        return true;
    }

    public boolean login(String email, String password) {
        if (email == null || email.trim().isEmpty()) {
            throw new IllegalArgumentException("Email is null or empty");
        }

        if (password == null || password.trim().isEmpty()) {
            throw new IllegalArgumentException("Password is null or empty");
        }

        return userRepository.findByEmail(email.trim().toLowerCase())
                .filter(user -> user.getPassword().equals(password))
                .map(user -> {
                    this.currentUser = user;
                    return true;
                })
                .orElse(false);
    }

    public boolean updateProfile(String newFullName, String newEmail, String newAddress) {
        if (currentUser == null) {
            return false;
        }

        if (!currentUser.getEmail().equals(newEmail.trim().toLowerCase())) {
            if (userRepository.existsByEmail(newEmail)) {
                throw new IllegalArgumentException("Email already exists");
            }
        }

        currentUser.setFullName(newFullName.trim());
        currentUser.setEmail(newEmail.trim().toLowerCase());
        currentUser.setAddress(newAddress);
        userRepository.save(currentUser);
        return true;
    }

    public boolean changePassword(String newPassword) {
        if (currentUser == null) {
            return false;
        }
        if (newPassword == null || newPassword.length() < 6) {
            throw new IllegalArgumentException("Password is less than 6 characters");
        }

        currentUser.setPassword(newPassword);
        userRepository.save(currentUser);
        return true;
    }


}
