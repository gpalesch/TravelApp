package com.example.destination_service;

import org.mapstruct.factory.Mappers;

public interface DestinationMapper {

    DestinationMapper INSTANCE = Mappers.getMapper(DestinationMapper.class);

    DestinationDTO toDestinationDTO(Destination destination);

    Destination toDestinationEntity(DestinationDTO destinationDTO);

    Destination toDestinationEntity(DestinationRequestDTO destinationRequestDTO);

    DestinationRequestDTO toDestinationRequestDTO(Destination destination);
}
