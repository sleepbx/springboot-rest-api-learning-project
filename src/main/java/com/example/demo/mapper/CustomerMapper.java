package com.example.demo.mapper;

import com.example.demo.dto.CreateCustomerRequestDTO;
import com.example.demo.dto.CustomerResponseDTO;
import com.example.demo.model.Customer;

public class CustomerMapper {

    public static Customer toEntity(CreateCustomerRequestDTO dto) {

        Customer customer = new Customer();
        customer.setName(dto.getName());
        customer.setEmail(dto.getEmail());
        customer.setPhone(dto.getPhone());

        return customer;
    }

    public static CustomerResponseDTO toResponse(Customer customer) {

        return new CustomerResponseDTO(
                customer.getId(),
                customer.getName(),
                customer.getEmail()
        );
    }
}