package com.dev.opera.app.controllers;

import com.dev.opera.app.model.Role;
import com.dev.opera.app.model.RoleName;
import com.dev.opera.app.model.User;
import com.dev.opera.app.service.RoleService;
import com.dev.opera.app.service.ShoppingCartService;
import com.dev.opera.app.service.UserService;
import java.util.Set;
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
        user.setRoleName(RoleName.USER);
        roleService.add(user);
        Role adminRole = new Role();
        adminRole.setRoleName(RoleName.ADMIN);
        roleService.add(adminRole);
        User admin = new User();
        admin.setRoles(Set.of(adminRole));
        admin.setEmail("bob@ukr.net");
        admin.setPassword("1234");
        userService.add(admin);
        shoppingCartService.registerNewShoppingCart(admin);
    }
}
