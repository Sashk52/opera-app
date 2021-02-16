package com.dev.movietheatre.controllers;

import com.dev.movietheatre.model.User;
import com.dev.movietheatre.model.dto.UserResponseDto;
import com.dev.movietheatre.service.UserMapper;
import com.dev.movietheatre.service.UserService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
public class UserController {

    private final UserService userService;
    private final UserMapper userMapper;

    public UserController(UserService userService, UserMapper userMapper) {
        this.userService = userService;
        this.userMapper = userMapper;
    }

    @GetMapping("/by-email")
    public UserResponseDto getbyEmail(@RequestParam String email) {
        User user = userService.findByEmail(email).get();
        return userMapper.mapUserToDto(user);

    }
}
