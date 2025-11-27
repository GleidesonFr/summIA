package com.backend.summia.repositories;

import java.util.List;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.backend.summia.models.FileEntity;

public interface FileRepository extends JpaRepository<FileEntity, UUID> {
    List<FileEntity> findByOwnerId(UUID ownerId);
}
