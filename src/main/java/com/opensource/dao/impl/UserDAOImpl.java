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

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Repository
@Transactional
public class UserDAOImpl implements UserDAO {

	// @Autowired
	// private SessionFactory sessionFactory;

	@PersistenceContext
	private EntityManager em;

	@Override
	public User getUser(String name) {

		List<User> userList = em
				.createNamedQuery("User.findByUserName", User.class)
				.setParameter("userName", name).getResultList();

		if (!userList.isEmpty())
			return (User) userList.get(0);
		else
			return null;

	}

	@SuppressWarnings("unchecked")
	@Override
	public List<User> getUsers() {
		List<User> userList = em.createNamedQuery("User.findAll", User.class)
				.getResultList();

		return userList;

	}

	@Override
	public User createUser(String name, String password, Set<Role> roles) {
		User user = new User(name, password, roles);
		em.persist(user);
		return user;
	}

	@Override
	public void deleteUser(String name) {
		User user = new User();
		user.setUserName(name);
		em.remove(user);
	}

	@Override
	public boolean hasRole(String name, String roleString) {
		if (StringUtils.isEmpty(roleString)) {
			return false;
		}
		User user = getUser(name);
		for (Role role : user.getRoles()) {
			if (roleString.equals(role.getRoleName())) {
				return true;
			}
		}
		return false;
	}

}
