package com.dev.opera.app.dao;

import com.dev.opera.app.model.Role;

public interface RoleDao {
    void add(Role role);

    Role getRoleByName(String role);
}
