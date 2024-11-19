package com.example.destination_service.dto;

import java.math.BigDecimal;
import java.util.UUID;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class DestinationDTO {

    private UUID id;
    private String name;
    private String description;
    private String localisation;
    private BigDecimal price;
    private boolean available;
    private String picUrl;
}
