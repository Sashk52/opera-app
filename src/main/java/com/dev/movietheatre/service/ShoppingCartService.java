package com.dev.movietheatre.service;

import com.dev.movietheatre.model.MovieSession;
import com.dev.movietheatre.model.ShoppingCart;
import com.dev.movietheatre.model.User;

public interface ShoppingCartService {
    void addSession(MovieSession movieSession, User user);

    ShoppingCart getByUser(User user);

    void registerNewShoppingCart(User user);

    void clear(ShoppingCart shoppingCart);
}
