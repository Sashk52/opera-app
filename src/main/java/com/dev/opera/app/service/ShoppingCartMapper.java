package com.dev.opera.app.service;

import com.dev.opera.app.model.ShoppingCart;
import com.dev.opera.app.model.dto.ShoppingCartResponseDto;

public interface ShoppingCartMapper {
    ShoppingCartResponseDto mapShoppingCartToDto(ShoppingCart shoppingCart);
}
