package com.dev.movietheatre.service.impl;

import com.dev.movietheatre.model.User;
import com.dev.movietheatre.model.dto.UserRequestDto;
import com.dev.movietheatre.model.dto.UserResponseDto;
import com.dev.movietheatre.service.UserMapper;
import org.springframework.stereotype.Component;

@Component
public class UserMapperImpl implements UserMapper {
    @Override
    public UserResponseDto mapUserToDto(User user) {
        UserResponseDto userResponseDto = new UserResponseDto();
        userResponseDto.setId(user.getId());
        userResponseDto.setEmail(user.getEmail());
        return userResponseDto;
    }

    @Override
    public User dtoToUser(UserRequestDto userRequestDto) {
        User user = new User();
        user.setEmail(userRequestDto.getEmail());
        user.setPassword(userRequestDto.getPassword());
        return user;
    }
}
