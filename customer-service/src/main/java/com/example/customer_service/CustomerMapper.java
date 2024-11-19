package com.example.customer_service;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.example.customer_service.dto.CustomerRequestDTO;
import com.example.customer_service.dto.CustomerResponseDTO;

@Mapper(componentModel = "spring")
public interface CustomerMapper {
    
    CustomerMapper INSTANCE = Mappers.getMapper(CustomerMapper.class);

    Customer toCustomer(CustomerRequestDTO customerRequestDTO);
    CustomerResponseDTO toCustomerResponseDTO(Customer customer);
}
