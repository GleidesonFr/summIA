package com.backend.summia.user.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.backend.summia.user.models.User;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, UUID>{
    Optional<User> findByUsername(String username);
    Optional<User> findByEmail(String email);
    boolean existsByUsername(String username);
}
