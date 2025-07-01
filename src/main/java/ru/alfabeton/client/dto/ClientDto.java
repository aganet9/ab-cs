package ru.alfabeton.client.dto;

import lombok.Data;
import jakarta.validation.constraints.*;

@Data
public class ClientDto {
    private Long id;

    @NotBlank
    private String firstName;

    @NotBlank
    private String lastName;

    @Pattern(regexp="\\+?[0-9]{7,15}")
    private String phone;

    @Email
    private String email;
}
