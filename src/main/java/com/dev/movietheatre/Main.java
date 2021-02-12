package com.dev.movietheatre;

import com.dev.movietheatre.exception.AuthenticationException;
import com.dev.movietheatre.lib.Injector;
import com.dev.movietheatre.model.CinemaHall;
import com.dev.movietheatre.model.Movie;
import com.dev.movietheatre.model.MovieSession;
import com.dev.movietheatre.model.ShoppingCart;
import com.dev.movietheatre.model.User;
import com.dev.movietheatre.security.AuthenticationService;
import com.dev.movietheatre.service.CinemaHallService;
import com.dev.movietheatre.service.MovieService;
import com.dev.movietheatre.service.MovieSessionService;
import com.dev.movietheatre.service.OrderService;
import com.dev.movietheatre.service.ShoppingCartService;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

public class Main {
    private static Injector injector = Injector.getInstance("com.dev.movietheatre");

    public static void main(String[] args) throws AuthenticationException {
        MovieService movieService = (MovieService) injector.getInstance(MovieService.class);
        Movie movie = new Movie();
        movie.setTitle("Call");
        movieService.add(movie);
        movieService.getAll().forEach(System.out::println);

        CinemaHallService cinemaHallService = (CinemaHallService) injector
                .getInstance(CinemaHallService.class);
        CinemaHall cinemaHall = new CinemaHall();
        cinemaHall.setDescription("Green");
        cinemaHallService.add(cinemaHall);
        cinemaHallService.getAll().forEach(System.out::println);

        MovieSessionService movieSessionService = (MovieSessionService) injector
                .getInstance(MovieSessionService.class);
        MovieSession movieSession = new MovieSession();
        movieSession.setMovie(movie);
        LocalDateTime localDateTime = LocalDateTime.of(2021, 02, 01, 15, 00);
        movieSession.setShowTime(localDateTime);
        movieSessionService.add(movieSession);
        LocalDate movieDate = LocalDate.of(2021, 02, 01);
        List<MovieSession> availableSessions = movieSessionService
                .findAvailableSessions(movie.getId(),
                        movieDate);
        System.out.println(availableSessions.toString());
        AuthenticationService authenticationService = (AuthenticationService) injector
                .getInstance(AuthenticationService.class);
        User registeredUser = authenticationService.register("Billy@ukr.net",
                "111");
        User loginedUser = authenticationService.login("Billy@ukr.net", "111");
        System.out.println("Registered user " + registeredUser.toString());
        System.out.println("Logined user " + loginedUser.toString());

        ShoppingCartService shoppingCartService = (ShoppingCartService) injector
                .getInstance(ShoppingCartService.class);
        User newRegisteredUser = authenticationService.register("Sam@ukr.net", "000");
        shoppingCartService.addSession(movieSession, newRegisteredUser);
        ShoppingCart shoppingCartByNewRegisteredUser = shoppingCartService
                .getByUser(newRegisteredUser);
        System.out.println("____There is Sam's shopping cart_____ "
                + shoppingCartByNewRegisteredUser);

        OrderService orderService = (OrderService) injector.getInstance(OrderService.class);
        ShoppingCart shoppingCartUserWithOrder = shoppingCartService.getByUser(newRegisteredUser);
        System.out.println("__Shopping card defore created order___" + shoppingCartUserWithOrder);
        orderService.completeOrder(shoppingCartUserWithOrder);
        System.out.println("__Order info__" + orderService.getOrdersHistory(newRegisteredUser));
        System.out.println("__Shopping cart after created order___" + shoppingCartUserWithOrder);
    }
}
