package com.backend.summia.dtos;

import jakarta.validation.constraints.NotBlank;

public record RegisterRequest(
    @NotBlank(message = "Full name is required") String fullName,
    @NotBlank(message = "Email is required") String email,
    @NotBlank(message = "Password is required") String password,
    @NotBlank(message = "Username is required") String username
){}
