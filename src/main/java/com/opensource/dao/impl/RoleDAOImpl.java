package com.opensource.dao.impl;

import com.opensource.dao.RoleDAO;
import com.opensource.model.Role;


import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Repository
@Transactional(readOnly=true)
public class RoleDAOImpl implements RoleDAO {

	@PersistenceContext
	private EntityManager em;
	
//    @Autowired
//    private SessionFactory sessionFactory;

    @Override
    public Role getRole(String name) {
    	
    	List<Role> roleList = em.createNamedQuery("Role.findByRoleName", Role.class).setParameter("roleName", name).getResultList();
		
        if (!roleList.isEmpty())
            return (Role) roleList.get(0);
        else
            return null;
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<Role> getRoles() {

    	List<Role> roleList = em.createNamedQuery("Role.findAll", Role.class).getResultList();
	
            return  roleList;
       
    }

}
