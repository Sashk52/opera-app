package com.dev.opera.app.service.impl;

import com.dev.opera.app.model.ShoppingCart;
import com.dev.opera.app.model.Ticket;
import com.dev.opera.app.model.dto.ShoppingCartResponseDto;
import com.dev.opera.app.service.ShoppingCartMapper;
import java.util.stream.Collectors;
import org.springframework.stereotype.Component;

@Component
public class ShoppingCartMapperImpl implements ShoppingCartMapper {
    @Override
    public ShoppingCartResponseDto mapShoppingCartToDto(ShoppingCart shoppingCart) {
        ShoppingCartResponseDto shoppingCartResponseDto = new ShoppingCartResponseDto();
        shoppingCartResponseDto.setUserId(shoppingCart.getId());
        shoppingCartResponseDto.setTicketIds(shoppingCart.getTickets()
                .stream()
                .map(Ticket::getId)
                .collect(Collectors.toList()));
        return shoppingCartResponseDto;
    }
}
