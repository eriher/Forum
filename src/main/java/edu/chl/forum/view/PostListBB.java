/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.chl.forum.view;

import edu.chl.forum.auth.ForumUser;
import edu.chl.forum.core.Forum;
import edu.chl.forum.core.IForum;
import edu.chl.forum.core.Post;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

/**
 *
 * @author olof
 */
@Named
@ViewScoped
public class PostListBB implements Serializable {

    private static final Logger LOG = Logger.getLogger(PostListBB.class.getName()); 
    private List<Post> posts;
    private IForum forum;
    
    protected PostListBB(){
        //for CDI
    }
         
    @Inject
    public PostListBB(IForum forum){
        this.forum = forum;
    }
    
    @PostConstruct
    public void init() {
        LOG.log(Level.INFO, "PostListBB alive {0}", this);
        
        forum.getPostCatalogue().create(new Post("Text1", new ForumUser()));
        forum.getPostCatalogue().create(new Post("Text2", new ForumUser()));
        forum.getPostCatalogue().create(new Post("Text3", new ForumUser()));
        
        System.out.println(forum.getPostCatalogue().count());
        posts = forum.getPostCatalogue().findAll();

    }
 
    public List<Post> getPosts() {
        return posts ;
    }
    
}
