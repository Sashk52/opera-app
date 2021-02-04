package com.dev.movietheatre.service;

import com.dev.movietheatre.model.Order;
import com.dev.movietheatre.model.ShoppingCart;
import com.dev.movietheatre.model.User;
import java.util.List;

public interface OrderService {
    Order completeOrder(ShoppingCart shoppingCart);

    List<Order> getOrdersHistory(User user);
}
