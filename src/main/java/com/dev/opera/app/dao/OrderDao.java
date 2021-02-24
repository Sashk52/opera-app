package com.dev.opera.app.dao;

import com.dev.opera.app.model.Order;
import com.dev.opera.app.model.User;
import java.util.List;

public interface OrderDao {
    Order add(Order order);

    List<Order> getOrdersHistory(User user);
}
