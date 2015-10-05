/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.opensource.model;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author Alexandr
 */
@Entity
@Table(name = "USERS_BOOKS")
public class UsersBooks implements Serializable {

    private static final long serialVersionUID = 1L;

    @EmbeddedId
    private UsersBooksPK id;

    @ManyToOne
    @MapsId("userId") //This is the name of attr in UsersBooksPK class
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne
    @MapsId("bookId")
    @JoinColumn(name = "book_id")
    private Book book;

    @Column(name = "date_added")
    @Temporal(TemporalType.TIMESTAMP)
    private String dateAdded;
    
    @Column(name = "font_id")
    private int fontId;
    
    @Column(name = "font_size")
    private int fontSize;
    
    @ManyToOne
    @JoinColumn(name = "background_id")
    private Book backgroundId;
    
    @Column(name = "current_book")
    private boolean currentBook;
    
    @Column(name = "current_position")
    private long currentPosition;
    
//User user = new User();
//Service service = new Service();
//UserService userService = new UserService();
//
//user.addUserService(userService);
//userService.setUser(user);
//
//service.addUserService(userService);
//userService.setService(service);
//
//session.save(user);
//session.save(service);
//session.save(userService);

    public UsersBooksPK getId() {
        return id;
    }

    public void setId(UsersBooksPK id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public String getDateAdded() {
        return dateAdded;
    }

    public void setDateAdded(String dateAdded) {
        this.dateAdded = dateAdded;
    }

    public int getFontId() {
        return fontId;
    }

    public void setFontId(int fontId) {
        this.fontId = fontId;
    }

    public int getFontSize() {
        return fontSize;
    }

    public void setFontSize(int fontSize) {
        this.fontSize = fontSize;
    }

    public Book getBackgroundId() {
        return backgroundId;
    }

    public void setBackgroundId(Book backgroundId) {
        this.backgroundId = backgroundId;
    }

    public boolean isCurrentBook() {
        return currentBook;
    }

    public void setCurrentBook(boolean currentBook) {
        this.currentBook = currentBook;
    }

    public long getCurrentPosition() {
        return currentPosition;
    }

    public void setCurrentPosition(long currentPosition) {
        this.currentPosition = currentPosition;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 59 * hash + Objects.hashCode(this.id);
        hash = 59 * hash + Objects.hashCode(this.user);
        hash = 59 * hash + Objects.hashCode(this.book);
        hash = 59 * hash + Objects.hashCode(this.dateAdded);
        hash = 59 * hash + this.fontId;
        hash = 59 * hash + this.fontSize;
        hash = 59 * hash + Objects.hashCode(this.backgroundId);
        hash = 59 * hash + (this.currentBook ? 1 : 0);
        hash = 59 * hash + (int) (this.currentPosition ^ (this.currentPosition >>> 32));
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final UsersBooks other = (UsersBooks) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        if (!Objects.equals(this.user, other.user)) {
            return false;
        }
        if (!Objects.equals(this.book, other.book)) {
            return false;
        }
        if (!Objects.equals(this.dateAdded, other.dateAdded)) {
            return false;
        }
        if (this.fontId != other.fontId) {
            return false;
        }
        if (this.fontSize != other.fontSize) {
            return false;
        }
        if (!Objects.equals(this.backgroundId, other.backgroundId)) {
            return false;
        }
        if (this.currentBook != other.currentBook) {
            return false;
        }
        if (this.currentPosition != other.currentPosition) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "UsersBooks{" + "id=" + id + ", user=" + user + ", book=" + book + ", dateAdded=" + dateAdded + ", fontId=" + fontId + ", fontSize=" + fontSize + ", backgroundId=" + backgroundId + ", currentBook=" + currentBook + ", currentPosition=" + currentPosition + '}';
    }
    
    
}
