package com.sugarfit.backend.service;

import com.sugarfit.backend.dto.ExampleRequest;
import com.sugarfit.backend.dto.ExampleResponse;
import com.sugarfit.backend.entity.ExampleRequestEntity;
import com.sugarfit.backend.repository.ExampleRequestRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.UUID;

@Service
public class ExampleService {

    private final ExampleRequestRepository repository;

    private static final Logger log =
            LoggerFactory.getLogger(ExampleService.class);

    public ExampleService(ExampleRequestRepository repository) {
        this.repository = repository;
    }

    @Transactional
    public ExampleResponse process(ExampleRequest request) {

        log.info("Processing example request for userId={}", request.userId());

        UUID requestId = UUID.randomUUID();

        ExampleRequestEntity entity = new ExampleRequestEntity(
                requestId,
                request.userId(),
                request.value(),
                "SUCCESS"
        );

        repository.save(entity);

        log.info("Successfully processed requestId={}", requestId);

        return new ExampleResponse("SUCCESS", requestId.toString());
    }
}
