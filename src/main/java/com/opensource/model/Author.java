/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.opensource.model;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.Size;

/**
 *
 * @author Alexandr
 */
@Entity
@Table(name = "authors")
@NamedQueries({
    @NamedQuery(name = "Author.findAll", query = "SELECT a FROM Author a"),
    @NamedQuery(name = "Author.findByAuthorId", query = "SELECT a FROM Author a WHERE a.authorId = :authorId"),
    @NamedQuery(name = "Author.findByAuthorShortName", query = "SELECT a FROM Author a WHERE a.authorShortName = :authorShortName"),
    @NamedQuery(name = "Author.findByAuthorFirstName", query = "SELECT a FROM Author a WHERE a.authorFirstName = :authorFirstName"),
    @NamedQuery(name = "Author.findByAuthorSecondName", query = "SELECT a FROM Author a WHERE a.authorSecondName = :authorSecondName"),
    @NamedQuery(name = "Author.findByAuthorSurname", query = "SELECT a FROM Author a WHERE a.authorSurname = :authorSurname"),
    @NamedQuery(name = "Author.findByAuthorDescription", query = "SELECT a FROM Author a WHERE a.authorDescription = :authorDescription")})
public class Author implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "author_id")
    private Integer authorId;
    @Size(max = 30)
    @Column(name = "author_short_name")
    private String authorShortName;
    @Size(max = 20)
    @Column(name = "author_first_name")
    private String authorFirstName;
    @Size(max = 20)
    @Column(name = "author_second_name")
    private String authorSecondName;
    @Size(max = 20)
    @Column(name = "author_surname")
    private String authorSurname;
    @Size(max = 100)
    @Column(name = "author_description")
    private String authorDescription;

    public Author() {
    }

    public Author(Integer authorId) {
        this.authorId = authorId;
    }

    public Integer getAuthorId() {
        return authorId;
    }

    public void setAuthorId(Integer authorId) {
        this.authorId = authorId;
    }

    public String getAuthorShortName() {
        return authorShortName;
    }

    public void setAuthorShortName(String authorShortName) {
        this.authorShortName = authorShortName;
    }

    public String getAuthorFirstName() {
        return authorFirstName;
    }

    public void setAuthorFirstName(String authorFirstName) {
        this.authorFirstName = authorFirstName;
    }

    public String getAuthorSecondName() {
        return authorSecondName;
    }

    public void setAuthorSecondName(String authorSecondName) {
        this.authorSecondName = authorSecondName;
    }

    public String getAuthorSurname() {
        return authorSurname;
    }

    public void setAuthorSurname(String authorSurname) {
        this.authorSurname = authorSurname;
    }

    public String getAuthorDescription() {
        return authorDescription;
    }

    public void setAuthorDescription(String authorDescription) {
        this.authorDescription = authorDescription;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (authorId != null ? authorId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Author)) {
            return false;
        }
        Author other = (Author) object;
        if ((this.authorId == null && other.authorId != null) || (this.authorId != null && !this.authorId.equals(other.authorId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Author{" + "authorId=" + authorId + ", authorShortName=" + authorShortName + ", authorFirstName=" + authorFirstName + ", authorSecondName=" + authorSecondName + ", authorSurname=" + authorSurname + ", authorDescription=" + authorDescription + '}';
    }

    
    
}
