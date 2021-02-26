package com.dev.opera.app.service;

import com.dev.opera.app.model.User;
import java.util.Optional;

public interface UserService {
    User add(User user);

    Optional<User> findByEmail(String email);

    User getById(Long id);
}
