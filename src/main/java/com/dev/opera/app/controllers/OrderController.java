package com.dev.opera.app.controllers;

import com.dev.opera.app.model.Order;
import com.dev.opera.app.model.dto.OrderResponseDto;
import com.dev.opera.app.service.OrderMapper;
import com.dev.opera.app.service.OrderService;
import com.dev.opera.app.service.ShoppingCartService;
import com.dev.opera.app.service.UserService;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/orders")
public class OrderController {
    private final OrderService orderService;
    private final ShoppingCartService shoppingCartService;
    private final UserService userService;
    private final OrderMapper orderMapper;

    public OrderController(OrderService orderService, ShoppingCartService shoppingCartService,
                           UserService userService, OrderMapper orderMapper) {
        this.orderService = orderService;
        this.shoppingCartService = shoppingCartService;
        this.userService = userService;
        this.orderMapper = orderMapper;
    }

    @PostMapping("/complete")
    public OrderResponseDto completeOrder(@RequestParam Long id) {
        Order order = orderService.completeOrder(shoppingCartService
                .getByUser(userService.getById(id)));
        return orderMapper.mapOrderToDto(order);
    }

    @GetMapping
    public List<OrderResponseDto> getOrdersHistoryByUser(@RequestParam Long id) {
        return orderService.getOrdersHistory(userService.getById(id))
                .stream()
                .map(orderMapper::mapOrderToDto)
                .collect(Collectors.toList());
    }
}
