package com.opensource.service;

import com.opensource.dao.RoleDAO;
import com.opensource.model.Role;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoleService {

    @Autowired
    RoleDAO roleDAO;

    public Role getRole(String name) {
        return roleDAO.getRole(name);
    }

    public List<Role> getRoles() {
        return roleDAO.getRoles();
    }
}
