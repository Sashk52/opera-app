package com.dev.movietheatre.service;

import com.dev.movietheatre.model.ShoppingCart;
import com.dev.movietheatre.model.dto.ShoppingCartResponseDto;

public interface ShoppingCartMapper {
    ShoppingCartResponseDto mapShoppingCartToDto(ShoppingCart shoppingCart);
}
