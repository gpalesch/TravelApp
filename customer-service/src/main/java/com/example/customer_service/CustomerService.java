package com.example.customer_service;

import java.util.UUID;

import org.springframework.stereotype.Service;

import com.example.customer_service.dto.CustomerRequestDTO;
import com.example.customer_service.dto.CustomerResponseDTO;

@Service
public class CustomerService {

    private final CustomerRepository customerRepository;
    private final CustomerMapper mapper;

    public CustomerService(CustomerRepository customerRepository, CustomerMapper mapper) {
        this.customerRepository = customerRepository;
        this.mapper = mapper;
    }

    public CustomerResponseDTO getCustomerById(UUID id) {
        Customer customer = customerRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("Customer not found"));
        return mapper.toCustomerResponseDTO(customer);
    }

    public CustomerResponseDTO createCustomer(CustomerRequestDTO customerRequestDTO) {
        Customer customer = mapper.toCustomer(customerRequestDTO);
        Customer newCustomer = customerRepository.save(customer);
        return mapper.toCustomerResponseDTO(newCustomer);
    }
    
}
