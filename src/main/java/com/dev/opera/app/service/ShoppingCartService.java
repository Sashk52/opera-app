package com.dev.opera.app.service;

import com.dev.opera.app.model.PerformanceSession;
import com.dev.opera.app.model.ShoppingCart;
import com.dev.opera.app.model.User;

public interface ShoppingCartService {
    void addSession(PerformanceSession performanceSession, User user);

    ShoppingCart getByUser(User user);

    void registerNewShoppingCart(User user);

    void clear(ShoppingCart shoppingCart);
}
