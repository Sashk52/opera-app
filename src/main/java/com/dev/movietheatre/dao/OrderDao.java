package com.dev.movietheatre.dao;

import com.dev.movietheatre.model.Order;
import com.dev.movietheatre.model.User;
import java.util.List;

public interface OrderDao {
    Order add(Order order);

    List<Order> getOrdersHistory(User user);
}
