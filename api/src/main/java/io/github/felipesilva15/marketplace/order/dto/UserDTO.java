package io.github.felipesilva15.marketplace.order.dto;

import lombok.Data;

@Data
public class UserDTO {
    private Long id;

    private String name;

    private String email;

    private String document;
}
