package com.sugarfit.template.controller;

import com.sugarfit.template.dto.ExampleRequest;
import com.sugarfit.template.dto.ExampleResponse;
import com.sugarfit.template.service.ExampleService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/example")
public class ExampleController {

    private final ExampleService exampleService;

    public ExampleController(ExampleService exampleService) {
        this.exampleService = exampleService;
    }

    @PostMapping
    public ExampleResponse process(@Valid @RequestBody ExampleRequest request) {
        return exampleService.process(request);
    }
}
