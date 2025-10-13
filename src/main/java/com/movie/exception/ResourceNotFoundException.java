package com.movie.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.io.Serial;

@RestControllerAdvice
public class ResourceNotFoundException extends RuntimeException {
    public ResourceNotFoundException() {
    }

    @Serial
    private static final long serialVersionUID = 1L;

    public ResourceNotFoundException(String message) {
        super(message);
    }

    public ResourceNotFoundException(HttpStatus notFound, String format) {
    }
}
