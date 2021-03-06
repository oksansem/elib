package com.opensource.dao.impl;

import com.opensource.dao.RoleDAO;
import com.opensource.model.Role;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional(readOnly=true)
public class RoleDAOImpl implements RoleDAO {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public Role getRole(String name) {
        Query query = openSession().createQuery("from Role r where r.name = :name");
        query.setParameter("name", name);
        List roleList = query.list();
        if (!roleList.isEmpty())
            return (Role) roleList.get(0);
        else
            return null;
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<Role> getRoles() {
        Query query = openSession().createQuery("from Role");
        return query.list();
    }

    private Session openSession() {
        return sessionFactory.getCurrentSession();
    }
}
