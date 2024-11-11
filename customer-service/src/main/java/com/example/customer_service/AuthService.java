package com.example.customer_service;

import org.springframework.stereotype.Service;

@Service
public class AuthService {

    private final CustomerRepository customerRepository;
    private final CustomerMapper mapper = CustomerMapper.INSTANCE;

    public AuthService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public CustomerDTO register(CustomerRegistrationDTO customerRegistrationDTO) {
        Customer customer = mapper.toCustomer(customerRegistrationDTO);
        Customer savedCustomer = customerRepository.save(customer);

        return mapper.toCustomerDTO(savedCustomer);
    }

    public CustomerDTO login(CustomerLoginDTO customerLoginDTO) {
        Customer customer = customerRepository.findByEmail(customerLoginDTO.getEmail());

        if (customer == null) {
            throw new RuntimeException("User not found");
        } 
        
        if (!customer.getPassword().equals(customerLoginDTO.getPassword())) {
            throw new RuntimeException("Invalid password");
        } 

        return mapper.toCustomerDTO(customer);
    }
    
}
