package com.dev.movietheatre.service.impl;

import com.dev.movietheatre.dao.UserDao;
import com.dev.movietheatre.lib.Inject;
import com.dev.movietheatre.lib.Service;
import com.dev.movietheatre.model.User;
import com.dev.movietheatre.service.UserService;
import com.dev.movietheatre.util.HashUtil;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {
    @Inject
    private UserDao userDao;

    @Override
    public User add(User user) {
        user.setSalt(HashUtil.getSalt());
        user.setPassword(HashUtil.hashPassword(user.getPassword(),user.getSalt()));
        return userDao.add(user);
    }

    @Override
    public Optional<User> findByEmail(String email) {
        return userDao.findByEmail(email);
    }
}
