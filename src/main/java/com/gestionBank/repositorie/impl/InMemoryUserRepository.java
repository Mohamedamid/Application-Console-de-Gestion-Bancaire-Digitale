package com.gestionBank.repositorie.impl;

import com.gestionBank.model.User;
import com.gestionBank.repositorie.UserRepository;
import  java.util.*;
import java.util.concurrent.ConcurrentHashMap;

public class InMemoryUserRepository implements UserRepository {
    private final Map<UUID, User> users = new ConcurrentHashMap<>();

    public User save(User user){
        users.put(user.getId(), user);
        return user;
    }

    public Optional<User> findById(UUID id) {
        return Optional.ofNullable(users.get(id));
    }

    public Optional<User> findByEmail(String email) {
        return users.values().stream().filter(user -> user.getEmail().equals(email)).findFirst();
    }

    public List<User> findAll(){
        return new ArrayList<>(users.values());
    }

    public void delete (UUID id){
        users.remove(id);
    }

    public boolean existsByEmail(String email){
        return users.values().stream().anyMatch(user -> user.getEmail().equals(email));
    }

}
