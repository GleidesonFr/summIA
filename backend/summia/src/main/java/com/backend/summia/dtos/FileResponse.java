package com.backend.summia.dtos;

import java.time.Instant;
import java.util.UUID;

public record FileResponse(
    UUID id,
    String originalName,
    String storageName,
    Long size,
    Instant uploadedAt
) {
    
}
