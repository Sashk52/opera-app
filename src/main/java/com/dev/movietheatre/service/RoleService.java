package com.dev.movietheatre.service;

import com.dev.movietheatre.model.Role;

public interface RoleService {
    void add(Role roles);

    Role getRoleByName(String role);
}
