package com.example.demo.controller;

import com.example.demo.dto.CreateCustomerRequestDTO;
import com.example.demo.dto.CustomerResponseDTO;
import com.example.demo.exception.CustomerNotFoundException;
import com.example.demo.mapper.CustomerMapper;
import com.example.demo.model.Customer;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/customers")
public class CustomerController {

    @GetMapping
    public ResponseEntity<String> getCustomers() {
        return ResponseEntity.ok("Customer list fetched");
    }

    @PostMapping
    public ResponseEntity<CustomerResponseDTO> createCustomer(
            @Valid @RequestBody CreateCustomerRequestDTO request
    ) {

        Customer customer = CustomerMapper.toEntity(request);

        customer.setId(1L); // dummy id

        CustomerResponseDTO response = CustomerMapper.toResponse(customer);

        return ResponseEntity.ok(response);
    }



    
    @GetMapping("/{id}")
public ResponseEntity<CustomerResponseDTO> getCustomer(@PathVariable Long id) {

    if(id != 1) {
        throw new CustomerNotFoundException("Customer not found with id " + id);
    }

    Customer customer = new Customer(1L,"Rahul","rahul@gmail.com","999999999");

    CustomerResponseDTO response =
            new CustomerResponseDTO(customer.getId(), customer.getName(), customer.getEmail());

    return ResponseEntity.ok(response);
}

}