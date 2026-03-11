package com.example.demo.dto;

import java.time.LocalDateTime;

import lombok.Getter;
import lombok.Setter;
@Getter
@Setter

public class CartResponseDTO {
    private long id;
    private long userId;
    private LocalDateTime createdAt;

    
}
