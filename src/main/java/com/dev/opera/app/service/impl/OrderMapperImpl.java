package com.dev.opera.app.service.impl;

import com.dev.opera.app.model.Order;
import com.dev.opera.app.model.Ticket;
import com.dev.opera.app.model.dto.OrderResponseDto;
import com.dev.opera.app.service.OrderMapper;
import java.util.stream.Collectors;
import org.springframework.stereotype.Component;

@Component
public class OrderMapperImpl implements OrderMapper {
    @Override
    public OrderResponseDto mapOrderToDto(Order order) {
        OrderResponseDto orderResponseDto = new OrderResponseDto();
        orderResponseDto.setId(order.getId());
        orderResponseDto.setEmail(order.getUser().getEmail());
        orderResponseDto.setDate(order.getOrderDate().toString());
        orderResponseDto.setTicketIds(order.getTickets()
                .stream()
                .map(Ticket::getId)
                .collect(Collectors.toList()));
        return orderResponseDto;
    }
}
