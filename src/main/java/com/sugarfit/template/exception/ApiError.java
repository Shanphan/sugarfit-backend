package com.sugarfit.template.exception;

public record ApiError(
        String code,
        String message
) {
}
