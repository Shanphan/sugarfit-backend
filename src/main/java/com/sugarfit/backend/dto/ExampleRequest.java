package com.sugarfit.backend.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record ExampleRequest(
        @NotBlank String userId,
        @NotNull Integer value
) {
}
