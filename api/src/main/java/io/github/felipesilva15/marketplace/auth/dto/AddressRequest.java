package io.github.felipesilva15.marketplace.auth.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.github.felipesilva15.marketplace.auth.model.User;
import jakarta.validation.constraints.*;
import lombok.Data;

@Data
public class AddressRequest {
    @NotBlank
    @Size(max = 80)
    private String name;

    @NotBlank
    @Size(min = 8, max = 8)
    @JsonProperty("postal_code")
    private String postalCode;

    @NotBlank
    @Size(max = 80)
    private String street;

    @NotBlank
    @Size(max = 40)
    private String locality;

    @NotBlank
    @Size(max = 60)
    private String city;

    @NotBlank
    @Size(max = 40)
    private String region;

    @NotBlank
    @Size(min = 2, max = 2)
    @JsonProperty("region_code")
    private String regionCode;

    @NotBlank
    @Size(max = 10)
    private String number;

    @Size(max = 120)
    private String complement;

    @NotNull
    private User user;
}
