package com.example.customer_service;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/users")
public class AuthController {

    private AuthService authService;

    @PostMapping("/register")
    public ResponseEntity<CustomerDTO> register(@RequestBody CustomerRegistrationDTO customerRegistrationDTO) {
        return ResponseEntity.ok(authService.register(customerRegistrationDTO));
    }

    @PostMapping("/login")
    public ResponseEntity<CustomerDTO> login(@RequestBody CustomerLoginDTO customerLoginDTO) {
        return ResponseEntity.ok(authService.login(customerLoginDTO));
    }
    
}
