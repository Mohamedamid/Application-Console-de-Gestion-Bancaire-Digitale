package com.gestionBank.repositorie;

import com.gestionBank.model.User;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface UserRepository {
    User save(User user);
    Optional<User> findById(UUID Id);
    Optional<User> findByEmail(String email);
    List<User> findAll();
    void delete(UUID id);
    boolean existsByEmail(String email);
}
