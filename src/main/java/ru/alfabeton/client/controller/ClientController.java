package ru.alfabeton.client.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import ru.alfabeton.client.dto.ClientDto;
import ru.alfabeton.client.service.ClientService;

import java.util.List;

@Tag(name = "Clients API", description = "Работа с клиентами")
@RestController
@RequestMapping("/api/clients")
@RequiredArgsConstructor
@Validated
public class ClientController {

    private final ClientService service;

    @Operation(summary = "Получить список клиентов")
    @GetMapping
    public List<ClientDto> findAll() {
        return service.findAll();
    }

    @Operation(summary = "Получить список клиентов с пагинацией")
    @GetMapping("/paged")
    public Page<ClientDto> findAllPaged(@RequestParam(defaultValue = "0") int page,
                                        @RequestParam(defaultValue = "10") int size) {
        return service.findAllPaged(PageRequest.of(page, size));
    }

    @Operation(summary = "Получить клиента по идентификатору")
    @GetMapping("/{id}")
    public ClientDto findById(@PathVariable Long id) {
        return service.findById(id);
    }

    @Operation(summary = "Создать нового клиента")
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ClientDto create(@Valid @RequestBody ClientDto dto) {
        return service.create(dto);
    }

    @Operation(summary = "Обновить данные клиента")
    @PutMapping("/{id}")
    public ClientDto update(@PathVariable Long id,
                            @Valid @RequestBody ClientDto dto) {
        return service.update(id, dto);
    }

    @Operation(summary = "Удалить клиента по идентификатору")
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }
}
