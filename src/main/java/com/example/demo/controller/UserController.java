package com.example.demo.controller;
import com.example.demo.model.User;

import jakarta.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.CreateUserRequestDTO;
import com.example.demo.dto.UserResponseDTO;
import com.example.demo.mapper.UserMapper;

@RestController
@RequestMapping("/users")
public class UserController {
    @GetMapping("/getuser")
public ResponseEntity<String> user() {
    return ResponseEntity.ok("User fetched successfully");
}
@PostMapping("/userdata")
public ResponseEntity<UserResponseDTO> usercreate(@Valid @RequestBody CreateUserRequestDTO request) {

    // 1️⃣ DTO -> Entity
    User user = new User();
    user.setUsername(request.getUsername());
    user.setEmail(request.getEmail());
    user.setPassword(request.getPassword());

    // values normally set by system
    user.setId(1L);
    user.setRole("USER");
    user.setActive(true);

    // 2️⃣ Entity -> ResponseDTO
    UserResponseDTO response = new UserResponseDTO(
            user.getId(),
            user.getUsername(),
            user.getEmail(),
            user.getRole()
    );

    return ResponseEntity.ok(response);
}
    @PostMapping("/mapping")
    public ResponseEntity<UserResponseDTO> usercre(@Valid @RequestBody CreateUserRequestDTO request) {

        // DTO -> Entity
        User user = UserMapper.toEntity(request);

        // simulate DB id
        user.setId(1L);

        // Entity -> ResponseDTO
        UserResponseDTO response = UserMapper.toResponse(user);

        return ResponseEntity.ok(response);
    }

    
}
