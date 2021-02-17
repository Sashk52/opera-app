package com.dev.movietheatre.service;

import com.dev.movietheatre.model.Order;
import com.dev.movietheatre.model.dto.OrderResponseDto;

public interface OrderMapper {
    OrderResponseDto mapOrderToDto(Order order);
}
