package com.dev.opera.app.service;

import com.dev.opera.app.model.Order;
import com.dev.opera.app.model.ShoppingCart;
import com.dev.opera.app.model.User;
import java.util.List;

public interface OrderService {
    Order completeOrder(ShoppingCart shoppingCart);

    List<Order> getOrdersHistory(User user);
}
