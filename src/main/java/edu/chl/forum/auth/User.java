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
    
    public User(){
        
    }
    
    public User(String name){
        this.name = name;
    }
    
    public String getName(){
        return name;
    }
}
