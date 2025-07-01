package ru.alfabeton.client.mapper;

import org.mapstruct.*;
import ru.alfabeton.client.dto.ClientDto;
import ru.alfabeton.client.entity.Client;

@Mapper(componentModel = "spring")
public interface ClientMapper {
    ClientDto toDto(Client entity);
    Client toEntity(ClientDto dto);

    void updateFromDto(ClientDto dto, @MappingTarget Client entity);
}
