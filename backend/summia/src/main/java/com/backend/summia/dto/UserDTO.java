package com.backend.summia.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;

public record UserDTO(
    @NotEmpty(message = "Nome completo é obrigatório.")String fullname,
    @NotEmpty(message = "Nome de usuário é obrigatório.")
    String username,
    @NotEmpty(message = "Email é obrigatório.") @Email(message = "Insira um email válido.")
    String email,
    @NotEmpty(message = "Senha é obrigatória.") @Min(value = 8, message = "A senha tem que ter, no mínimo 8 caracteres.") 
    String password,
    String profileImage,
    String bio
) {
    
}
