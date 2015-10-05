package com.opensource.dao;

import com.opensource.model.Role;

import java.util.List;

public interface RoleDAO {

    public Role getRole(String name);
    public List<Role> getRoles();
}
