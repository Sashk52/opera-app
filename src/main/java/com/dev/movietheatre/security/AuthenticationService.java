package com.dev.movietheatre.security;

import com.dev.movietheatre.exception.AuthenticationException;
import com.dev.movietheatre.model.User;

public interface AuthenticationService {
    User login(String email, String password) throws AuthenticationException;

    User register(String email, String password);
}
