package com.backend.summia.dtos;

import jakarta.validation.constraints.NotBlank;

public record LoginRequest(
    @NotBlank(message = "Username or email are required") String usernameOrEmail,
    @NotBlank(message = "Password is required") String password
) {
    
}
