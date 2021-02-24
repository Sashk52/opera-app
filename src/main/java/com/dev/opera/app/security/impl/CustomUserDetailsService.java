package com.dev.opera.app.security.impl;

import com.dev.opera.app.model.User;
import com.dev.opera.app.service.UserService;
import org.springframework.security.core.userdetails.User.UserBuilder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class CustomUserDetailsService implements UserDetailsService {
    private final UserService userService;

    public CustomUserDetailsService(UserService userService) {
        this.userService = userService;
    }

    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        User user = userService.findByEmail(userName)
                .orElseThrow(() -> new UsernameNotFoundException("User was not found: "
                        + userName));

        UserBuilder builder = org.springframework.security.core.userdetails.User.builder();
        builder.username(user.getEmail());
        builder.password(user.getPassword());
        builder.authorities(user.getRoles()
                .stream()
                .map(n -> n.getRoleName().name())
                .toArray(String[]::new));
        return builder.build();
    }
}
