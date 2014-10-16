/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package edu.chl.forum.core;

import edu.chl.forum.util.AbstractEntity;
import javax.persistence.Entity;

/**
 *
 * @author Olof
 */
@Entity
public class Post extends AbstractEntity  {

    private String name;
    private String message;

    public Post() {
    }
    
    public Post(String name, String message){
        this.name = name;
        this.message = message;
    }
    
    public Post(Long id, String name, String message){
        super(id);
        this.name = name;
        this.message = message;
    }

    public String getName(){
        return name;
    }
    
    public String getMessage() {
        return message;
    }
    
}
