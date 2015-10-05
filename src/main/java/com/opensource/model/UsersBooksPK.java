/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.opensource.model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 *
 * @author Alexandr
 */
@Embeddable
public class UsersBooksPK implements Serializable{

    @Column(name = "user_id")
    private int userId;

    @Column(name = "book_id")
    private Long bookId;
}
