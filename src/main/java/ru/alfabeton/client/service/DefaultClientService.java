package ru.alfabeton.client.service;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;
import ru.alfabeton.client.dto.ClientDto;
import ru.alfabeton.client.exception.ClientNotFoundException;
import ru.alfabeton.client.mapper.ClientMapper;
import ru.alfabeton.client.repository.ClientRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
@Validated
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
                .orElseThrow(() -> new ClientNotFoundException(id));
    }

    @Override
    public ClientDto create(ClientDto dto) {
        return mapper.toDto(repo.save(mapper.toEntity(dto)));
    }

    @Override
    public ClientDto update(Long id, ClientDto dto) {
        var existing = repo.findById(id)
                .orElseThrow(() -> new ClientNotFoundException(id));
        mapper.updateFromDto(dto, existing);
        return mapper.toDto(repo.save(existing));
    }

    @Override
    public void delete(Long id) {
        repo.deleteById(id);
    }

    @Override
    public Page<ClientDto> findAllPaged(Pageable pageable) {
        return repo.findAll(pageable).map(mapper::toDto);
    }
}
