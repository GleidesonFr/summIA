package com.backend.summia.dtos;

import java.util.List;
import java.util.UUID;

import jakarta.validation.constraints.NotEmpty;

public record CreateSummaryRequest(
    @NotEmpty(message = "Content must not be empty") List<UUID> fileIds
) {
    
}
