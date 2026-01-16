package com.sugarfit.backend.controller;

import com.sugarfit.backend.dto.ExampleRequest;
import com.sugarfit.backend.dto.ExampleResponse;
import com.sugarfit.backend.service.ExampleService;
import jakarta.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/examples")
public class ExampleController {

    private final ExampleService exampleService;

    private static final Logger log =
            LoggerFactory.getLogger(ExampleController.class);

    public ExampleController(ExampleService exampleService) {
        this.exampleService = exampleService;
    }

    @PostMapping("/example")
    public ExampleResponse process(@Valid @RequestBody ExampleRequest request) {

        log.debug("Received /example request");
        return exampleService.process(request);
    }
}
