package com.backend.summia.services;

import java.time.Instant;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.backend.summia.config.JwtUtil;
import com.backend.summia.dtos.RegisterRequest;
import com.backend.summia.errors.EmailAlreadyExists;
import com.backend.summia.errors.UsernameAlreadyExists;
import com.backend.summia.models.User;
import com.backend.summia.repositories.UserRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AuthService {
    
    private final UserRepository userRepo;
    private final PasswordEncoder encoder;
    private final JwtUtil jwtUtil;

    public void register(RegisterRequest request){
        if(userRepo.existsByEmail(request.email())){
            throw new EmailAlreadyExists();
        }

        if(userRepo.existsByUsername(request.username())){
            throw new UsernameAlreadyExists();
        }

        User user = User.builder()
                        .fullName(request.fullName())
                        .email(request.email())
                        .username(request.username())
                        .password(request.password())
                        .createdAt(Instant.now())
                        .build();

        userRepo.save(user);
    }
}
