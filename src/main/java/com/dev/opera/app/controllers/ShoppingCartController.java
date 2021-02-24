package com.dev.opera.app.controllers;

import com.dev.opera.app.model.ShoppingCart;
import com.dev.opera.app.model.dto.ShoppingCartResponseDto;
import com.dev.opera.app.service.PerformanceSessionService;
import com.dev.opera.app.service.ShoppingCartMapper;
import com.dev.opera.app.service.ShoppingCartService;
import com.dev.opera.app.service.UserService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/shopping-carts")
public class ShoppingCartController {
    private final ShoppingCartService shoppingCartService;
    private final PerformanceSessionService performanceSessionService;
    private final UserService userService;
    private final ShoppingCartMapper shoppingCartMapper;

    public ShoppingCartController(ShoppingCartService shoppingCartService,
                                  PerformanceSessionService performanceSessionService,
                                  UserService userService,
                                  ShoppingCartMapper shoppingCartMapper) {
        this.shoppingCartService = shoppingCartService;
        this.performanceSessionService = performanceSessionService;
        this.userService = userService;
        this.shoppingCartMapper = shoppingCartMapper;
    }

    @PostMapping("/performance-sessions")
    public void addPerformanceSession(@RequestParam Long userId,
                                      @RequestParam Long performanceSessionId) {
        shoppingCartService.addSession(performanceSessionService.getById(performanceSessionId),
                userService.getById(userId));
    }

    @GetMapping("/by-user")
    public ShoppingCartResponseDto getByUser(@RequestParam Long userId) {
        ShoppingCart shoppingCart = shoppingCartService.getByUser(userService.getById(userId));
        return shoppingCartMapper.mapShoppingCartToDto(shoppingCart);
    }
}
