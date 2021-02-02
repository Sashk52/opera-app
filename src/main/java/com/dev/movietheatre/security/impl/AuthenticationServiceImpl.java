package com.dev.movietheatre.security.impl;

import com.dev.movietheatre.exception.AuthenticationException;
import com.dev.movietheatre.lib.Inject;
import com.dev.movietheatre.lib.Service;
import com.dev.movietheatre.model.User;
import com.dev.movietheatre.security.AuthenticationService;
import com.dev.movietheatre.service.UserService;
import com.dev.movietheatre.util.HashUtil;
import java.util.Optional;

@Service
public class AuthenticationServiceImpl implements AuthenticationService {
    @Inject
    private UserService userService;

    @Override
    public User login(String email, String password) throws AuthenticationException {
        Optional<User> userByEmail = userService.findByEmail(email);
        if (userByEmail.isPresent() & userByEmail.get().getPassword()
                .equals(HashUtil.hashPassword(password,userByEmail.get().getSalt()))) {
            return userByEmail.get();
        }
        throw new AuthenticationException("Email or password is incorrect");
    }

    @Override
    public User register(String email, String password) {
        User user = new User();
        user.setEmail(email);
        user.setPassword(password);
        return userService.add(user);
    }
}
