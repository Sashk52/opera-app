package com.dev.movietheatre.service.impl;

import com.dev.movietheatre.model.ShoppingCart;
import com.dev.movietheatre.model.Ticket;
import com.dev.movietheatre.model.dto.ShoppingCartResponseDto;
import com.dev.movietheatre.service.ShoppingCartMapper;
import java.util.stream.Collectors;
import org.springframework.stereotype.Component;

@Component
public class ShoppingCartMapperImpl implements ShoppingCartMapper {
    @Override
    public ShoppingCartResponseDto mapShoppingCartToDto(ShoppingCart shoppingCart) {
        ShoppingCartResponseDto shoppingCartResponseDto = new ShoppingCartResponseDto();
        shoppingCartResponseDto.setUserId(shoppingCart.getId());
        shoppingCartResponseDto.setTicketId(shoppingCart.getTickets()
                .stream()
                .map(Ticket::getId)
                .collect(Collectors.toList()));
        return shoppingCartResponseDto;
    }
}
