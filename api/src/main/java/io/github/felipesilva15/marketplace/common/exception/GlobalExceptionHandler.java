package io.github.felipesilva15.marketplace.common.exception;

import io.github.felipesilva15.marketplace.common.dto.ApiErrorDTO;
import jakarta.persistence.EntityNotFoundException;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.ServletWebRequest;
import org.springframework.web.context.request.WebRequest;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ApiErrorDTO> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, WebRequest webRequest) {
        Map<String, List<String>> errors = ex.getBindingResult()
                .getFieldErrors()
                .stream()
                .collect(Collectors.groupingBy(
                        FieldError::getField,
                        Collectors.mapping(FieldError::getDefaultMessage, Collectors.toList())
                ));

        HttpServletRequest request = ((ServletWebRequest) webRequest).getRequest();

        ApiErrorDTO response = new ApiErrorDTO(
                LocalDateTime.now(),
                "Validation Error",
                "There are validation errors in your request.",
                request.getRequestURI(),
                request.getMethod(),
                errors
        );

        return ResponseEntity.status(HttpStatus.UNPROCESSABLE_ENTITY).body(response);
    }

    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity<ApiErrorDTO> handleEntityNotFound(EntityNotFoundException ex, WebRequest webRequest) {
        HttpServletRequest request = ((ServletWebRequest) webRequest).getRequest();

        ApiErrorDTO response = new ApiErrorDTO(
                LocalDateTime.now(),
                "Resource not found",
                "Cannot find the specified resource.",
                request.getRequestURI(),
                request.getMethod(),
                new HashMap<>()
        );

        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ApiErrorDTO> handleAllUncaughtException(Exception ex, WebRequest webRequest) {
        System.err.println("Erro interno não tratado: " + ex.getMessage());
        ex.printStackTrace();

        HttpServletRequest request = ((ServletWebRequest) webRequest).getRequest();

        ApiErrorDTO response = new ApiErrorDTO(
                LocalDateTime.now(),
                "Unhandled error",
                ex.getMessage(),
                request.getRequestURI(),
                request.getMethod(),
                new HashMap<>()
        );

        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
    }
}
