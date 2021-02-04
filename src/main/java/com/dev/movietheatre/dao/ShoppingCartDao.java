package com.dev.movietheatre.dao;

import com.dev.movietheatre.model.ShoppingCart;
import com.dev.movietheatre.model.User;

public interface ShoppingCartDao {
    ShoppingCart add(ShoppingCart shoppingCart);

    ShoppingCart getByUser(User user);

    void update(ShoppingCart shoppingCart);
}
