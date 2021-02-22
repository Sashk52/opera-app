package com.dev.movietheatre.service.impl;

import com.dev.movietheatre.dao.RoleDao;
import com.dev.movietheatre.model.Role;
import com.dev.movietheatre.service.RoleService;
import org.springframework.stereotype.Service;

@Service
public class RoleServiceImpl implements RoleService {
    private final RoleDao roleDao;

    public RoleServiceImpl(RoleDao roleDao) {
        this.roleDao = roleDao;
    }

    @Override
    public void add(Role roles) {
        roleDao.add(roles);
    }

    @Override
    public Role getRoleByName(String role) {
        return roleDao.getRoleByName(role);
    }
}
