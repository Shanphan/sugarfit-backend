package com.sugarfit.backend.service;

import com.sugarfit.backend.dto.ExampleRequest;
import com.sugarfit.backend.dto.ExampleResponse;
import com.sugarfit.backend.repository.ExampleRequestRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class ExampleServiceTest {

    @Autowired
    private ExampleService exampleService;

    @Autowired
    private ExampleRequestRepository repository;

    @Test
    void shouldPersistRequestAndReturnSuccess() {

        ExampleRequest request = new ExampleRequest("user-123", 50);

        ExampleResponse response = exampleService.process(request);

        assertThat(response.status()).isEqualTo("SUCCESS");
        assertThat(response.requestId()).isNotNull();

        assertThat(repository.findById(
                java.util.UUID.fromString(response.requestId()))
        ).isPresent();
    }
}
