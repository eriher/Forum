/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.chl.forum.auth;

import edu.chl.forum.util.AbstractEntity;
import javax.persistence.Entity;

/**
 *
 * @author erik
 */
@Entity
public class ForumUser extends AbstractEntity{
    
    private String name;
    private String password;
    private String email;
    private int rank;

    public ForumUser(){
    
    }
    
    public ForumUser(String name){
        this.name = name;
        this.password = "password";
        this.email = "";
        this.rank = 0;
    }
    
    public ForumUser(long id, String name) {
        super(id);
        this.name = name;
    }
    
    public ForumUser(String name, String password, String email) {
        this.name = name;
        this.password = password;
        this.email = email;
        this.rank = 0;
    }
    
    public ForumUser(String name, String password, String email, int rank) {
        this.name = name;
        this.password = password;
        this.email = email;
        this.rank = rank;
    }
    
    public String getPassword() {
        return password;
    }

    public String getEmail() {
        return email;
    }

    public int getRank() {
        return rank;
    }
    
    public String getName(){
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setRank(int rank) {
        this.rank = rank;
    }
}
