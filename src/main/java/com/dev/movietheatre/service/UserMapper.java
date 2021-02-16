package com.dev.movietheatre.service;

import com.dev.movietheatre.model.User;
import com.dev.movietheatre.model.dto.UserResponseDto;

public interface UserMapper {
    UserResponseDto mapUserToDto(User user);
}
