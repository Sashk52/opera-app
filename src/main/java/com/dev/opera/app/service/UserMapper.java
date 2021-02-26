package com.dev.opera.app.service;

import com.dev.opera.app.model.User;
import com.dev.opera.app.model.dto.UserRequestDto;
import com.dev.opera.app.model.dto.UserResponseDto;

public interface UserMapper {
    UserResponseDto mapUserToDto(User user);

    User dtoToUser(UserRequestDto dto);
}
