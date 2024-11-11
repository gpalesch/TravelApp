package com.example.customer_service;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface CustomerMapper {
    
    CustomerMapper INSTANCE = Mappers.getMapper(CustomerMapper.class);

    Customer toCustomer(CustomerRegistrationDTO customerRegistrationDTO);
    CustomerDTO toCustomerDTO(Customer customer);
}
