package com.example.demo.mapper;

import com.example.demo.model.Cart;
import com.example.demo.dto.CartRequestDTO;
import com.example.demo.dto.CartResponseDTO;

public class CartMapper {

    public static Cart toEntity(CartRequestDTO cartRequestDTO) {
        Cart cart = new Cart();
        cart.setUserId(cartRequestDTO.getUserId());
        return cart;
    }

    public static CartResponseDTO toResponse(Cart cart) {
        CartResponseDTO dto = new CartResponseDTO();
        dto.setId(cart.getId());
        dto.setUserId(cart.getUserId());
        dto.setCreatedAt(cart.getCreatedAt());
        return dto;
    }
}