package com.backend.summia.user.services;

import java.time.Instant;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.backend.summia.dto.UserDTO;
import com.backend.summia.exceptions.UserAlreadyExists;
import com.backend.summia.exceptions.UserNotFound;
import com.backend.summia.user.models.User;
import com.backend.summia.user.repository.UserRepository;

@Service
public class UserService {
    
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public User createUser(UserDTO user){
        if(userRepository.existsByUsername(user.username())){
            throw new UserAlreadyExists();
        }else{
            User savedUserInfo = new User();
            savedUserInfo.setFullName(user.fullname());
            savedUserInfo.setUsername(user.username());
            savedUserInfo.setProfileImage(user.profileImage());
            savedUserInfo.setPassword(encodePassword(user.password()));
            savedUserInfo.setEmail(user.email());
            savedUserInfo.setCreatedAt(Instant.now());
            savedUserInfo.setBio(user.bio());
            return userRepository.save(savedUserInfo);
        }
    }

    public User getById(UUID id){
        return userRepository.findById(id).orElseThrow(() -> new UserNotFound());           
    }

    public User getByUsername(String username){
        return userRepository.findByUsername(username).orElseThrow(() -> new UserNotFound());
    }

    public User updateProfile(UUID id, UserDTO userInfoUpdated){
        User user = userRepository.findById(id).orElseThrow(() -> new UserNotFound());

        user.setBio(userInfoUpdated.bio());
        user.setEmail(userInfoUpdated.email());
        user.setFullName(userInfoUpdated.fullname());
        if(!checkPassword(userInfoUpdated.password(), user.getPassword())){
            user.setPassword(encodePassword(userInfoUpdated.password()));
        }
        user.setProfileImage(userInfoUpdated.profileImage());
        user.setUsername(userInfoUpdated.username());
        return userRepository.saveAndFlush(user);
    }

    private String encodePassword(String rawPassword){
        return passwordEncoder.encode(rawPassword);
    }

    private boolean checkPassword(String rawPassword, String encodedPassword){
        return passwordEncoder.matches(rawPassword, encodedPassword);
    }

    public void deleteUser(UUID id){
        userRepository.deleteById(id);
    }
}
