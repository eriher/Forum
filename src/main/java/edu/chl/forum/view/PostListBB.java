/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.chl.forum.view;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;


/**
 *
 * @author olof
 */
@ManagedBean
@ViewScoped
public class PostListBB implements Serializable {

    private static final Logger LOG = Logger.getLogger(PostListBB.class.getName()); 
    private List<String> posts;
         
    
    @PostConstruct
    public void init() {
        LOG.log(Level.INFO, "PostListBB alive {0}", this);
        posts = new ArrayList<>();
        for(int i=0;i<10;i++){
            posts.add("Post"+Integer.toString(i));
        }
    }
 
    public List<String> getPosts() {
        return posts;
    }
    
}
