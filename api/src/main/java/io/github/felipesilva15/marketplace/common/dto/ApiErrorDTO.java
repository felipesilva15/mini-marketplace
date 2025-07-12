package io.github.felipesilva15.marketplace.common.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.Collections;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ApiErrorDTO {
    private LocalDateTime timestamp;
    private String error;
    private String message;
    private String path;
    private String method;
    private List<ValidationErrorDTO> errors = Collections.emptyList();
}