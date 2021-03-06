package com.opensource.dao.impl;

import com.opensource.dao.UserDAO;
import com.opensource.model.Role;
import com.opensource.model.User;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import java.util.List;
import java.util.Set;

@Repository
@Transactional
public class UserDAOImpl implements UserDAO{

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public User getUser(String name) {
        Query query = openSession().createQuery("from User u where u.name = :name");
        query.setParameter("name", name);
        List userList = query.list();
        if (!userList.isEmpty())
            return (User) userList.get(0);
        else
            return null;
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<User> getUsers() {
        Query query = openSession().createQuery("from User");
        return query.list();
    }

    @Override
    public User createUser(String name, String password, Set<Role> roles) {
        User user = new User(name, password, roles);
        openSession().save(user);
        return user;
    }

    @Override
    public void deleteUser(String name) {
        User user = new User();
        user.setName(name);
        openSession().delete(user);
    }

    @Override
    public boolean hasRole(String name, String roleString) {
        if (StringUtils.isEmpty(roleString)) {
            return false;
        }
        User user = getUser(name);
        for (Role role : user.getRoles()) {
            if (roleString.equals(role.getName())) {
                return true;
            }
        }
        return false;
    }

    private Session openSession() {
        return sessionFactory.getCurrentSession();
    }
}
