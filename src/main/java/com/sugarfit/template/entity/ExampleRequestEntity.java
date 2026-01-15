package com.sugarfit.template.entity;

import jakarta.persistence.*;
import java.time.Instant;
import java.util.UUID;

@Entity
@Table(name = "example_requests")
public class ExampleRequestEntity {

    @Id
    @Column(nullable = false, updatable = false)
    private UUID id;

    @Column(name = "user_id", nullable = false)
    private String userId;

    @Column(name = "request_value", nullable = false)
    private Integer value;

    @Column(nullable = false)
    private String status;

    @Column(name = "created_at", nullable = false)
    private Instant createdAt;

    protected ExampleRequestEntity() {}

    public ExampleRequestEntity(UUID id, String userId, Integer value, String status) {
        this.id = id;
        this.userId = userId;
        this.value = value;
        this.status = status;
        this.createdAt = Instant.now();
    }
}
