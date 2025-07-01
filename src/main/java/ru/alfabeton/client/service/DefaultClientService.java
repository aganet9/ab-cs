package ru.alfabeton.client.service;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import ru.alfabeton.client.dto.ClientDto;
import ru.alfabeton.client.mapper.ClientMapper;
import ru.alfabeton.client.repository.ClientRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DefaultClientService implements ClientService {
    private final ClientRepository repo;
    private final ClientMapper mapper;

    @Override
    public List<ClientDto> findAll() {
        return repo.findAll().stream()
                .map(mapper::toDto)
                .toList();
    }

    @Override
    public ClientDto findById(Long id) {
        return repo.findById(id)
                .map(mapper::toDto)
                .orElseThrow(() ->
                        new ResponseStatusException(HttpStatus.NOT_FOUND, "Client not found with id " + id));
    }

    @Override
    public ClientDto create(ClientDto dto) {
        return mapper.toDto(repo.save(mapper.toEntity(dto)));
    }

    @Override
    public ClientDto update(Long id, ClientDto dto) {
        var existing = repo.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Client not found with id " + id));
        mapper.updateFromDto(dto, existing);
        return mapper.toDto(repo.save(existing));
    }

    @Override
    public void delete(Long id) {
        repo.deleteById(id);
    }
}
