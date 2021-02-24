package com.dev.opera.app.service;

import com.dev.opera.app.model.Order;
import com.dev.opera.app.model.dto.OrderResponseDto;

public interface OrderMapper {
    OrderResponseDto mapOrderToDto(Order order);
}
