package com.dev.movietheatre.service.impl;

import com.dev.movietheatre.dao.ShoppingCartDao;
import com.dev.movietheatre.dao.TicketDao;
import com.dev.movietheatre.lib.Inject;
import com.dev.movietheatre.lib.Service;
import com.dev.movietheatre.model.MovieSession;
import com.dev.movietheatre.model.ShoppingCart;
import com.dev.movietheatre.model.Ticket;
import com.dev.movietheatre.model.User;
import com.dev.movietheatre.service.ShoppingCartService;

@Service
public class ShoppingCartServiceImpl implements ShoppingCartService {
    @Inject
    private ShoppingCartDao shoppingCartDao;
    @Inject
    private TicketDao ticketDao;

    @Override
    public void addSession(MovieSession movieSession, User user) {
        Ticket ticket = new Ticket();
        ticket.setMovieSession(movieSession);
        ticket.setUser(user);
        if (shoppingCartDao.getByUser(user) != null) {
            ticketDao.add(ticket);
            ShoppingCart shoppingCartByUser = shoppingCartDao.getByUser(user);
            shoppingCartByUser.getTickets().add(ticket);
            shoppingCartDao.update(shoppingCartByUser);
        }
    }

    @Override
    public ShoppingCart getByUser(User user) {
        return shoppingCartDao.getByUser(user);
    }

    @Override
    public void registerNewShoppingCart(User user) {
        ShoppingCart newShoppingCart = new ShoppingCart();
        newShoppingCart.setUser(user);
        shoppingCartDao.add(newShoppingCart);
    }

    @Override
    public void clear(ShoppingCart shoppingCart) {
        shoppingCart.getTickets().clear();
        shoppingCartDao.update(shoppingCart);
    }
}
