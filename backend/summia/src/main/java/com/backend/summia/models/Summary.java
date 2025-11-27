package com.backend.summia.models;

import java.time.Instant;
import java.util.List;
import java.util.UUID;

import org.hibernate.annotations.CreationTimestamp;

import com.backend.summia.models.enums.SummaryType;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = Summary.TABLE_NAME)
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Summary {
    
    public static final String TABLE_NAME = "summaries";

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private UUID id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinTable(
        name = "summary_files",
        joinColumns = @JoinColumn(name = "summary_id"),
        inverseJoinColumns = @JoinColumn(name = "file_id")
    )
    private List<FileEntity> files;

    @Enumerated(EnumType.STRING)
    private SummaryType summaryType;

    @Column(name = "summary_text", columnDefinition = "TEXT")
    private String summaryText;

    @CreationTimestamp
    @Column(name = "created_at", nullable = false, updatable = false)
    private Instant createdAt;
}
