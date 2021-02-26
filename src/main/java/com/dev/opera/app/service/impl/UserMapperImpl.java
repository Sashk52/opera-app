package com.dev.opera.app.service.impl;

import com.dev.opera.app.model.User;
import com.dev.opera.app.model.dto.UserRequestDto;
import com.dev.opera.app.model.dto.UserResponseDto;
import com.dev.opera.app.service.RoleService;
import com.dev.opera.app.service.UserMapper;
import org.springframework.stereotype.Component;

@Component
public class UserMapperImpl implements UserMapper {
    private final RoleService roleService;

    public UserMapperImpl(RoleService roleService) {
        this.roleService = roleService;
    }

    @Override
    public UserResponseDto mapUserToDto(User user) {
        UserResponseDto userResponseDto = new UserResponseDto();
        userResponseDto.setId(user.getId());
        userResponseDto.setEmail(user.getEmail());
        return userResponseDto;
    }

    @Override
    public User dtoToUser(UserRequestDto dto) {
        User user = new User();
        user.setEmail(dto.getEmail());
        user.setPassword(dto.getPassword());
        return user;
    }
}
