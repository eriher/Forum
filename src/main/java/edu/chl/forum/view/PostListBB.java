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
    public void init() {/*
        LOG.log(Level.INFO, "PostListBB alive {0}", this);
        posts = new ArrayList<>();
        for(int i=0;i<10;i++){
            posts.add("Post"+Integer.toString(i));
        }*/
       // initTestData();
    }
 
    public List<Post> getPosts() {
        posts.add(forum.getPostCatalogue().find(4L));
        return posts;
    }
    
    private void initTestData(){
        Long i = 2212L;
        forum.getPostCatalogue().create(new Post(i,"Text", new ForumUser(), new Date()));
        forum.getPostCatalogue().create(new Post(22L,"Text", new ForumUser(), new Date()));
        forum.getPostCatalogue().create(new Post(33L,"Text", new ForumUser(), new Date()));
        forum.getPostCatalogue().create(new Post(44L,"Text", new ForumUser(), new Date()));
    } 
    
}
