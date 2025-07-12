package io.github.felipesilva15.marketplace.auth.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class AddressResponse {
    private Long id;

    private String name;

    @JsonProperty("postal_code")
    private String postalCode;

    private String street;

    private String locality;

    private String city;

    private String region;

    @JsonProperty("region_code")
    private String regionCode;

    private String number;

    private String complement;

    private Long user_id;

    @JsonProperty("created_at")
    private LocalDateTime createdAt;

    @JsonProperty("updated_at")
    private LocalDateTime updatedAt;
}
