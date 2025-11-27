package com.backend.summia.repositories;

import java.util.List;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.backend.summia.models.Summary;

public interface SummaryRepository extends JpaRepository<Summary, UUID> {
    List<Summary> findAllByFileId(UUID fileId);
}
