/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.opensource.model;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author Alexandr
 */
@Entity
@Table(name = "users")
@NamedQueries({
    @NamedQuery(name = "User.findAll", query = "SELECT u FROM User u"),
    @NamedQuery(name = "User.findByUserId", query = "SELECT u FROM User u WHERE u.userId = :userId"),
    @NamedQuery(name = "User.findByUserName", query = "SELECT u FROM User u WHERE u.userName = :userName"),
    @NamedQuery(name = "User.findByUserPassword", query = "SELECT u FROM User u WHERE u.userPassword = :userPassword"),
    @NamedQuery(name = "User.findByUserLogin", query = "SELECT u FROM User u WHERE u.userLogin = :userLogin"),
    @NamedQuery(name = "User.findByUserEmail", query = "SELECT u FROM User u WHERE u.userEmail = :userEmail"),
    @NamedQuery(name = "User.findByBlocked", query = "SELECT u FROM User u WHERE u.blocked = :blocked")})
public class User implements Serializable {
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "user_id")
    private Integer userId;
    
    @Size(max = 50)
    @NotNull
    @Column(name = "user_name")
    private String userName;
    
    @Size(max = 50)
    @Column(name = "user_password")
    private String userPassword;
    
    @Basic(optional = false)
    @NotNull
    @Column(name = "user_login")
    private String userLogin;
    
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "user_email")
    private String userEmail;
    
    @Column(name = "blocked")
    private Boolean blocked;
    
    @ManyToMany
    @JoinTable(
            name = "USERS_ROLES",
            joinColumns = {
                @JoinColumn(name = "user_id", referencedColumnName = "user_id")},
            inverseJoinColumns = {
                @JoinColumn(name = "role_id", referencedColumnName = "role_id")})
    private Set<Role> roles;
    
//    @ManyToMany
//    @JoinTable(
//            name = "USERS_BOOKS",
//            joinColumns = {
//                @JoinColumn(name = "user_id", referencedColumnName = "user_id")},
//            inverseJoinColumns = {
//                @JoinColumn(name = "book_id", referencedColumnName = "book_id")})
//    private Set<Book> books;

    
    public Set<Role> getRoles() {
		return roles;
	}

	public void setRoles(Set<Role> roles) {
		this.roles = roles;
	}

	public Set<UsersBooks> getUsersBooks() {
		return usersBooks;
	}

	public void setUsersBooks(Set<UsersBooks> usersBooks) {
		this.usersBooks = usersBooks;
	}

	@OneToMany(mappedBy = "book")
    private Set<UsersBooks> usersBooks = new HashSet<UsersBooks>();
    
    
    public User() {
    }

    public User(Integer userId) {
        this.userId = userId;
    }

    public User(Integer userId, String userLogin, String userEmail) {
        this.userId = userId;
        this.userLogin = userLogin;
        this.userEmail = userEmail;
    }

    public User(String name, String password, Set<Role> roles) {
		this.setUserName(name);
		this.setUserPassword(password);
		this.setRoles(roles);
	}

	public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    public String getUserLogin() {
        return userLogin;
    }

    public void setUserLogin(String userLogin) {
        this.userLogin = userLogin;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public Boolean getBlocked() {
        return blocked;
    }

    public void setBlocked(Boolean blocked) {
        this.blocked = blocked;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (userId != null ? userId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof User)) {
            return false;
        }
        User other = (User) object;
        if ((this.userId == null && other.userId != null) || (this.userId != null && !this.userId.equals(other.userId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mycompany.elib.entity.User[ userId=" + userId + " ]";
    }
    
}
