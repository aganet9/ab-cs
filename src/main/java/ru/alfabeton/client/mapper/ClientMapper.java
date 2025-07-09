package ru.alfabeton.client.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import ru.alfabeton.client.dto.ClientDto;
import ru.alfabeton.client.entity.Client;

@Mapper(componentModel = "spring")
public interface ClientMapper {
    ClientDto toDto(Client entity);

    @Mapping(target = "id" , ignore = true)
    Client toEntity(ClientDto dto);

    @Mapping(target = "id" , ignore = true)
    void updateFromDto(ClientDto dto, @MappingTarget Client entity);
}
