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
public class User extends AbstractEntity{
    
    private String name;
    private String password;
    private String email;
    private int rank;

    public User(){
        
    }
    
    public User(String name){
        this.name = name;
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
    

}
