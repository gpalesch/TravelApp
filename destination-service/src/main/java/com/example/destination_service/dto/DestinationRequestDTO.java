package com.example.destination_service.dto;

import java.math.BigDecimal;

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
    private BigDecimal price;
    private boolean available;
    private String picUrl;
}
