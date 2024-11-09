package com.example.destination_service;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class DestinationRequestDTO {
    
    private String name;
    private String description;
    private String localisation;
    private String picUrl;
}
