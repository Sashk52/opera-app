package com.dev.opera.app.service;

import com.dev.opera.app.model.Role;

public interface RoleService {
    void add(Role roles);

    Role getRoleByName(String role);
}
