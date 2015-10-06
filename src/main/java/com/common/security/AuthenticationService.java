package com.common.security;

import com.opensource.dao.UserDAO;
import com.opensource.model.Role;
import com.opensource.model.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Set;


@Service
@Transactional(readOnly=true)
public class AuthenticationService implements UserDetailsService {

    @Autowired
    private UserDAO userDAO;

    
    public UserDetails loadUserByUsername(String login)
            throws UsernameNotFoundException {
    	System.out.println("*************************In user autentification service!*************************");
        User user = userDAO.getUser(login);
        if (user != null) {
            return new org.springframework.security.core.userdetails.User(
                    user.getUserName(),
                    user.getUserPassword(),
                    true,
                    true,
                    true,
                    true,
                    getAuthorities(user.getRoles())
            );
        } else {
            throw new UsernameNotFoundException("User not found");
        }
    }

    public Collection<? extends GrantedAuthority> getAuthorities(Set<Role> roles) {
        List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
        for (Role role : roles) {
            authorities.add(new SimpleGrantedAuthority(role.getRoleName()));
        }
        return authorities;
    }
}
