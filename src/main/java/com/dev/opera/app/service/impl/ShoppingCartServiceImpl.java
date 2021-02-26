package com.dev.opera.app.service.impl;

import com.dev.opera.app.dao.ShoppingCartDao;
import com.dev.opera.app.dao.TicketDao;
import com.dev.opera.app.model.PerformanceSession;
import com.dev.opera.app.model.ShoppingCart;
import com.dev.opera.app.model.Ticket;
import com.dev.opera.app.model.User;
import com.dev.opera.app.service.ShoppingCartService;
import org.springframework.stereotype.Service;

@Service
public class ShoppingCartServiceImpl implements ShoppingCartService {
    private final ShoppingCartDao shoppingCartDao;
    private final TicketDao ticketDao;

    public ShoppingCartServiceImpl(ShoppingCartDao shoppingCartDao,
                                   TicketDao ticketDao) {
        this.shoppingCartDao = shoppingCartDao;
        this.ticketDao = ticketDao;
    }

    @Override
    public void addSession(PerformanceSession performanceSession, User user) {
        Ticket ticket = new Ticket();
        ticket.setMovieSession(performanceSession);
        ticket.setUser(user);
        ShoppingCart shoppingCartByUser = shoppingCartDao.getByUser(user);
        ticketDao.add(ticket);
        shoppingCartByUser.getTickets().add(ticket);
        shoppingCartDao.update(shoppingCartByUser);
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
