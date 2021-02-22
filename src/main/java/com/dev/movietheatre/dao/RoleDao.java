package com.dev.movietheatre.dao;

import com.dev.movietheatre.model.Role;

public interface RoleDao {
    void add(Role role);

    Role getRoleByName(String role);
}
