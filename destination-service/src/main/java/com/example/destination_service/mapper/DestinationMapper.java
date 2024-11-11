package com.example.destination_service.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.example.destination_service.Destination;
import com.example.destination_service.dto.DestinationDTO;
import com.example.destination_service.dto.DestinationRequestDTO;

@Mapper(componentModel = "spring")
public interface DestinationMapper {

    DestinationMapper INSTANCE = Mappers.getMapper(DestinationMapper.class);

    Destination toDestinationEntity(DestinationRequestDTO destinationRequestDTO);
    DestinationDTO toDestinationDTO(Destination destination);
}
