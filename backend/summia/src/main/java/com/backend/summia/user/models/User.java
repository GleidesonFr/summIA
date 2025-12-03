package com.backend.summia.user.models;

import java.time.Instant;
import java.util.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = User.TABLE_NAME)
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
    
    private static final String TABLE_NAME = "users";

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @Column(name = "full_name", nullable = false)
    private String fullName;

    @Column(name = "username", nullable = false)
    private String username;

    @Column(name = "email", nullable = false)
    private String email;

    @Column(name = "password", nullable = false)
    private String password;

    @Column(name = "profile_image", nullable = true)
    private String profileImage;

    @Column(name = "bio", nullable = true)
    private String bio;

    @Column(name = "created_at", nullable = false)
    private Instant createdAt;
}
