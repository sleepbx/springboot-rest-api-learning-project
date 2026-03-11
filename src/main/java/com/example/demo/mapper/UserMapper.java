package com.example.demo.mapper;

import com.example.demo.dto.CreateUserRequestDTO;
import com.example.demo.dto.UserResponseDTO;
import com.example.demo.model.User;

public class UserMapper {

    public static User toEntity(CreateUserRequestDTO request) {

        User user = new User();
        user.setUsername(request.getUsername());
        user.setEmail(request.getEmail());
        user.setPassword(request.getPassword());

        user.setRole("USER");
        user.setActive(true);

        return user;
    }

    public static UserResponseDTO toResponse(User user) {

        return new UserResponseDTO(
                user.getId(),
                user.getUsername(),
                user.getEmail(),
                user.getRole()
        );
    }
}