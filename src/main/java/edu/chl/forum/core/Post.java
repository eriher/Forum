/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package edu.chl.forum.core;

import edu.chl.forum.util.AbstractEntity;

/**
 *
 * @author Olof
 */
public class Post extends AbstractEntity  {

    private final String name;
    private final String message;
    
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
