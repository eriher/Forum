/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.chl.forum.view;

import edu.chl.forum.core.IForum;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

/**
 *
 * @author Olof
 */
@Named
@RequestScoped
public class PostListBB {
    private IForum forum;
    private static final Logger LOG = Logger.getLogger(PostListBB.class.getName());

    protected PostListBB(){
        
    }
    
    @PostConstruct
    public void post() {
        LOG.log(Level.INFO, "PostListBB alive {0}", this);
    }
    
    @PreDestroy
    public void pre() {
        LOG.log(Level.INFO, "PostListBB to be destroyed {0}", this);
    }
    
   
    public int getPosts(Long id){
        return forum.getPostCatalogue().getAllPosts(id);
    }
    
    
}
