package com.example.destination_service;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface DestinationMapper {

    DestinationMapper INSTANCE = Mappers.getMapper(DestinationMapper.class);

    Destination toDestinationEntity(DestinationRequestDTO destinationRequestDTO);
    DestinationDTO toDestinationDTO(Destination destination);
}
