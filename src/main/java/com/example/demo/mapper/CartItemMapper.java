package com.example.demo.mapper;

import com.example.demo.dto.CartItemRequestDTO;
import com.example.demo.model.CartItem;

public class CartItemMapper {

    public static CartItem toEntity(CartItemRequestDTO dto) {

        CartItem item = new CartItem();
        item.setProductId(dto.getProductId());
        item.setQuantity(dto.getQuantity());

        return item;
    }

}