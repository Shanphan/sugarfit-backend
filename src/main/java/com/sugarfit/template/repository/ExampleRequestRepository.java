package com.sugarfit.template.repository;

import com.sugarfit.template.entity.ExampleRequestEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ExampleRequestRepository
        extends JpaRepository<ExampleRequestEntity, UUID> {
}
