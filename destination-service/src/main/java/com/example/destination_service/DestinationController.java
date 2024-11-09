package com.example.destination_service;

import java.util.List;
import java.util.UUID;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping (value = "/destinations")
public class DestinationController {

    private DestinationService destinationService;
    
    @GetMapping("")
    public ResponseEntity<List<DestinationDTO>> getDestinations() {
        return ResponseEntity.ok(destinationService.getDestinations());
    }

    @GetMapping("/{id}")
    public ResponseEntity<DestinationDTO> getDestination(@PathVariable UUID id) {
        return ResponseEntity.ok(destinationService.getDestination(id));
    }

    @PostMapping("")
    public ResponseEntity<DestinationDTO> createDestination(@RequestBody DestinationRequestDTO destinationRequest) {
        return ResponseEntity.ok(destinationService.createDestination(destinationRequest));
    }

    @PutMapping("/{id}")
    public ResponseEntity<DestinationDTO> updateDestination(@PathVariable UUID id, @RequestBody DestinationRequestDTO destinationRequest) {
        return ResponseEntity.ok(destinationService.updateDestination(id, destinationRequest));
    }

    @DeleteMapping("/{id}")
    public void deleteDestination(@PathVariable UUID id) { // responseentity ?
        this.destinationService.deleteDestination(id);
    }

}
