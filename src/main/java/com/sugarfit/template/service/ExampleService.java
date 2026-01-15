package com.sugarfit.template.service;

import com.sugarfit.template.dto.ExampleRequest;
import com.sugarfit.template.dto.ExampleResponse;
import com.sugarfit.template.entity.ExampleRequestEntity;
import com.sugarfit.template.repository.ExampleRequestRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

@Service
public class ExampleService {

    private final ExampleRequestRepository repository;

    public ExampleService(ExampleRequestRepository repository) {
        this.repository = repository;
    }

    @Transactional
    public ExampleResponse process(ExampleRequest request) {

        UUID requestId = UUID.randomUUID();

        ExampleRequestEntity entity = new ExampleRequestEntity(
                requestId,
                request.userId(),
                request.value(),
                "SUCCESS"
        );

        repository.save(entity);

        return new ExampleResponse("SUCCESS", requestId.toString());
    }
}
