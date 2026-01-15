package com.sugarfit.backend.repository;

import com.sugarfit.backend.entity.ExampleRequestEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ExampleRequestRepository
        extends JpaRepository<ExampleRequestEntity, UUID> {
}
