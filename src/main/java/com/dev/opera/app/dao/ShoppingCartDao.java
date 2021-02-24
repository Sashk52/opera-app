package com.dev.opera.app.dao;

import com.dev.opera.app.model.ShoppingCart;
import com.dev.opera.app.model.User;

public interface ShoppingCartDao {
    ShoppingCart add(ShoppingCart shoppingCart);

    ShoppingCart getByUser(User user);

    void update(ShoppingCart shoppingCart);
}
