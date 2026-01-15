package com.sugarfit.backend.exception;

public record ApiError(
        String code,
        String message
) {
}
