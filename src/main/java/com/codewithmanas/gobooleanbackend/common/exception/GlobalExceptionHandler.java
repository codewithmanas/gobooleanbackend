package com.codewithmanas.gobooleanbackend.common.exception;

import com.codewithmanas.gobooleanbackend.common.util.ApiResponse;
import jakarta.servlet.http.HttpServletRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.List;
import java.util.UUID;

@RestControllerAdvice
public class GlobalExceptionHandler {
    private static final Logger log = LoggerFactory.getLogger(GlobalExceptionHandler.class);

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ApiResponse<List<String>>>  handleValidationException(MethodArgumentNotValidException ex, HttpServletRequest httpServletRequest) {

        String path = httpServletRequest.getRequestURI();
        String requestId = UUID.randomUUID().toString();

        List<String> errors = ex.getBindingResult()
                .getFieldErrors()
                .stream()
                .map(error -> error.getField() + " ; " + error.getDefaultMessage())
                .toList();

        log.warn("[requestId={}] Invalid  request", requestId);

        ApiResponse<List<String>> response = new ApiResponse<>(
                400,
                "Invalid Request",
                null,
                errors,
                requestId,
                path
        );

        return ResponseEntity.badRequest().body(response);
    }

    @ExceptionHandler(EmailAlreadyExistsException.class)
    public ResponseEntity<ApiResponse<List<String>>>  handleEmailAlreadyExistsException(EmailAlreadyExistsException ex, HttpServletRequest httpServletRequest) {

        String path = httpServletRequest.getRequestURI();
        String requestId = UUID.randomUUID().toString();

        log.warn("[requestId={}] Email already exists", requestId);

        ApiResponse<List<String>> response = new ApiResponse<>(
                400,
                "Email address already exists",
                null,
                ex.getMessage(),
                requestId,
                path
        );

        return ResponseEntity.badRequest().body(response);
    }


}
