package io.github.felipesilva15.marketplace.common.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ApiErrorDTO {
    private LocalDateTime timestamp;
    private String error;
    private String message;
    private String path;
    private String method;
    private Map<String, List<String>> errors = new HashMap<>();
}