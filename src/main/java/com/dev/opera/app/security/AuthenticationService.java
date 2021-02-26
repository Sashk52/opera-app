package com.dev.opera.app.security;

import com.dev.opera.app.model.User;

public interface AuthenticationService {

    User register(String email, String password);
}
