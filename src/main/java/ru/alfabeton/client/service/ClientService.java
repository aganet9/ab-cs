package ru.alfabeton.client.service;

import ru.alfabeton.client.dto.ClientDto;

import java.util.List;

public interface ClientService {
    List<ClientDto> findAll();

    ClientDto findById(Long id);

    ClientDto create(ClientDto dto);

    ClientDto update(Long id, ClientDto dto);

    void delete(Long id);
}
