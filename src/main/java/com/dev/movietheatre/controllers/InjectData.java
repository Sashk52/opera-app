package com.dev.movietheatre.controllers;

import com.dev.movietheatre.model.Role;
import com.dev.movietheatre.model.Roles;
import com.dev.movietheatre.model.User;
import com.dev.movietheatre.service.RoleService;
import com.dev.movietheatre.service.ShoppingCartService;
import com.dev.movietheatre.service.UserService;
import java.util.List;
import javax.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class InjectData {
    private final RoleService roleService;
    private final UserService userService;
    private final ShoppingCartService shoppingCartService;

    @Autowired
    public InjectData(RoleService roleService, UserService userService,
                      ShoppingCartService shoppingCartService) {
        this.roleService = roleService;
        this.userService = userService;
        this.shoppingCartService = shoppingCartService;
    }

    @PostConstruct
    private void inject() {
        Role user = new Role();
        user.setRoleName(Roles.USER);
        roleService.add(user);
        Role adminRole = new Role();
        adminRole.setRoleName(Roles.ADMIN);
        roleService.add(adminRole);
        User admin = new User();
        admin.setRoles(List.of(adminRole));
        admin.setEmail("bob@ukr.net");
        admin.setPassword("1234");
        userService.add(admin);
        shoppingCartService.registerNewShoppingCart(admin);
    }
}
