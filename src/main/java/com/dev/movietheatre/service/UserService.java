package com.dev.movietheatre.service;

import com.dev.movietheatre.model.User;
import java.util.Optional;

public interface UserService {
    User add(User user);

    Optional<User> findByEmail(String email);
}
