package ru.alfabeton.client.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.Data;

@Data
@Schema(description = "Данные клиентов")
public class ClientDto {

    @Schema(description = "Идентификатор", example = "1")
    private Long id;

    @NotBlank
    @Schema(description = "Имя", example = "Иван")
    private String firstName;

    @NotBlank
    @Schema(description = "Фамилия", example = "Иванов")
    private String lastName;

    @Pattern(regexp = "\\+?[0-9]{7,15}")
    @Schema(description = "Номер телефона", example = "+79001234567")
    private String phone;

    @Email
    @Schema(description = "Почта", example = "ivanov@alfabeton.ru")
    private String email;
}
