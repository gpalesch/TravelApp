package com.example.destination_service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;
import org.springframework.stereotype.Service;

@Service
public class DestinationService {

    private final DestinationRepository destinationRepository;
    private final DestinationMapper mapper = DestinationMapper.INSTANCE;

    public DestinationService(DestinationRepository destinationRepository) {
        this.destinationRepository = destinationRepository;
    }

    public List<DestinationDTO> getDestinations() {
        return destinationRepository.findAll().stream().map(mapper::toDestinationDTO).collect(Collectors.toList());
    }

    public DestinationDTO getDestination(UUID id) {
        Destination destination = destinationRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("Destination not found"));
        return mapper.toDestinationDTO(destination);
    }

    public DestinationDTO createDestination(DestinationRequestDTO destinationRequest) {
        Destination destination = mapper.toDestinationEntity(destinationRequest);
        Destination savedDestination = destinationRepository.save(destination);
        return mapper.toDestinationDTO(savedDestination);
    }

    public DestinationDTO updateDestination(UUID id, DestinationRequestDTO destinationRequest) {

        Destination destination = destinationRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("Destination not found"));
        
        mapper.toDestinationEntity(destinationRequest);

        destination.setName(destinationRequest.getName());
        destination.setDescription(destinationRequest.getDescription());
        destination.setLocalisation(destinationRequest.getLocalisation());
        destination.setPicUrl(destinationRequest.getPicUrl());

        Destination savedDestination = destinationRepository.save(destination);

        return mapper.toDestinationDTO(savedDestination);
    }

    public void deleteDestination(UUID id) {
        destinationRepository.deleteById(id);
    }

    
}
