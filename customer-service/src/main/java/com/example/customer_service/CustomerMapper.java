package com.example.customer_service;

import org.mapstruct.factory.Mappers;

public interface CustomerMapper {
    
    CustomerMapper INSTANCE = Mappers.getMapper(CustomerMapper.class);

    Customer toCustomer(CustomerRegistrationDTO customerRegistrationDTO);
    Customer toCustomer(CustomerLoginDTO customerLoginDTO);
    CustomerDTO toCustomerDTO(Customer customer);
}
