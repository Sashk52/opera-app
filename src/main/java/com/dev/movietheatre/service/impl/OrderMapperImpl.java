package com.dev.movietheatre.service.impl;

import com.dev.movietheatre.model.Order;
import com.dev.movietheatre.model.Ticket;
import com.dev.movietheatre.model.dto.OrderResponseDto;
import com.dev.movietheatre.service.OrderMapper;
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
        orderResponseDto.setTicketsId(order.getTickets()
                .stream()
                .map(Ticket::getId)
                .collect(Collectors.toList()));
        return orderResponseDto;
    }
}
