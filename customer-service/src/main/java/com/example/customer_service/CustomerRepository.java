package com.example.customer_service;

import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, UUID>{
    
    Customer findByEmail(String email);
}
