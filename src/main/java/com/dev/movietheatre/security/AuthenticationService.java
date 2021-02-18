package com.dev.movietheatre.security;

import com.dev.movietheatre.model.User;

public interface AuthenticationService {

    User register(String email, String password);
}
