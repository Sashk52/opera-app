package com.dev.movietheatre.service.impl;

import com.dev.movietheatre.dao.OrderDao;
import com.dev.movietheatre.lib.Inject;
import com.dev.movietheatre.lib.Service;
import com.dev.movietheatre.model.Order;
import com.dev.movietheatre.model.ShoppingCart;
import com.dev.movietheatre.model.User;
import com.dev.movietheatre.service.OrderService;
import com.dev.movietheatre.service.ShoppingCartService;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {
    @Inject
    private OrderDao orderDao;
    @Inject
    private ShoppingCartService shoppingCartService;

    @Override
    public Order completeOrder(ShoppingCart shoppingCart) {
        Order order = new Order();
        order.setTickets(new ArrayList<>(shoppingCart.getTickets()));
        order.setOrderDate(LocalDateTime.now());
        order.setUser(shoppingCart.getUser());
        shoppingCartService.clear(shoppingCart);
        return orderDao.add(order);
    }

    @Override
    public List<Order> getOrdersHistory(User user) {
        return orderDao.getOrdersHistory(user);
    }
}
