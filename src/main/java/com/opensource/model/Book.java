/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.opensource.model;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.Lob;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author Alexandr
 */
@Entity
@Table(name = "books", catalog = "elibrary", schema = "")
@NamedQueries({
    @NamedQuery(name = "Book.findAll", query = "SELECT b FROM Book b"),
    @NamedQuery(name = "Book.findByBookId", query = "SELECT b FROM Book b WHERE b.bookId = :bookId"),
    @NamedQuery(name = "Book.findByBookName", query = "SELECT b FROM Book b WHERE b.bookName = :bookName"),
    @NamedQuery(name = "Book.findByBookAddedDate", query = "SELECT b FROM Book b WHERE b.bookAddedDate = :bookAddedDate"),
    @NamedQuery(name = "Book.findByAccessTypeId", query = "SELECT b FROM Book b WHERE b.accessType = :accessType")})
public class Book implements Serializable {

    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "book_id")
    private Integer bookId;
    
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 60)
    @Column(name = "book_name")
    private String bookName;
    
    @Lob
    @Size(max = 65535)
    @Column(name = "book_descriptions")
    private String bookDescriptions;
    
    @Basic(optional = false)
    @NotNull
    @Column(name = "book_added_date")
    @Temporal(TemporalType.DATE)
    private Date bookAddedDate;
    
    @ManyToOne
    @JoinColumn(name = "access_type_id")
    private AccessType accessType;
    
    @ManyToMany
    @JoinTable(
            name = "BOOKS_CATEGORIES",
            joinColumns = {
                @JoinColumn(name = "book_id", referencedColumnName = "book_id")},
            inverseJoinColumns = {
                @JoinColumn(name = "category_id", referencedColumnName = "category_id")})
    private Set<Category> categories;
    @ManyToMany
    @JoinTable(
            name = "BOOKS_AUTHORS",
            joinColumns = {
                @JoinColumn(name = "book_id", referencedColumnName = "book_id")},
            inverseJoinColumns = {
                @JoinColumn(name = "author_id", referencedColumnName = "author_id")})
    private Set<Author> authors;
    @ManyToMany
    @JoinTable(
            name = "BOOKS_FILES",
            joinColumns = {
                @JoinColumn(name = "book_id", referencedColumnName = "book_id")},
            inverseJoinColumns = {
                @JoinColumn(name = "file_id", referencedColumnName = "file_id")})
    private Set<File> files;
//    @ManyToMany(mappedBy = "books")
//    private Set<User> users;
    
    @OneToMany(mappedBy = "user")
        private Set<UsersBooks> usersBooks = new HashSet<UsersBooks>();

    public Book() {
    }

    public Book(Integer bookId) {
        this.bookId = bookId;
    }

    public Book(Integer bookId, String bookName, Date bookAddedDate) {
        this.bookId = bookId;
        this.bookName = bookName;
        this.bookAddedDate = bookAddedDate;
    }

    public Integer getBookId() {
        return bookId;
    }

    public void setBookId(Integer bookId) {
        this.bookId = bookId;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public String getBookDescriptions() {
        return bookDescriptions;
    }

    public void setBookDescriptions(String bookDescriptions) {
        this.bookDescriptions = bookDescriptions;
    }

    public Date getBookAddedDate() {
        return bookAddedDate;
    }

    public void setBookAddedDate(Date bookAddedDate) {
        this.bookAddedDate = bookAddedDate;
    }

    public AccessType getAccessType() {
        return accessType;
    }

    public void setAccessType(AccessType accessType) {
        this.accessType = accessType;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (bookId != null ? bookId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Book)) {
            return false;
        }
        Book other = (Book) object;
        if ((this.bookId == null && other.bookId != null) || (this.bookId != null && !this.bookId.equals(other.bookId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Book{" + "bookId=" + bookId + ", bookName=" + bookName + ", bookDescriptions=" + bookDescriptions + ", bookAddedDate=" + bookAddedDate + ", accessType=" + accessType.getAccessTypeName() + '}';
    }

}
