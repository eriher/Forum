/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.chl.forum.core;

import java.io.Serializable;
import javax.enterprise.context.ApplicationScoped;

/**
 *
 * @author Olof
 * A wrapper for the forum
 */
@ApplicationScoped
public class SingletonForum implements Serializable{
    
    private final IForum forum = Forum.newInstance();
    
    public IForum getForum(){
        return forum;
    }
}
