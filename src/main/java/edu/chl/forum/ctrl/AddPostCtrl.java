/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.chl.forum.ctrl;

import edu.chl.forum.auth.LoginBean;
import edu.chl.forum.core.ForumThread;
import edu.chl.forum.core.IForum;
import edu.chl.forum.core.Post;
import edu.chl.forum.view.AddPostBB;
import edu.chl.forum.util.Navigation;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

/**
 *
 * @author erik
 */
@Named
@RequestScoped
public class AddPostCtrl {
    
    private AddPostBB postBB;
    private static final Logger LOG = Logger.getLogger(AddPostCtrl.class.getName());
    private IForum forum;
    @Inject Navigation nav;
    @Inject LoginBean login;
    
    protected AddPostCtrl(){
    }
    
    @PostConstruct
    public void post() {
        LOG.log(Level.INFO, "AddPostCtrl alive {0}", this);
    }
    
    @PreDestroy
    public void pre() {
        LOG.log(Level.INFO, "AddPostCtrl to be destroyed {0}", this);
    }
    
    @Inject
    public AddPostCtrl(IForum forum){
        this.forum = forum;
    }
   
    @Inject
    public void setPostBB(AddPostBB postBB){
        this.postBB = postBB;
    }
    
    // Will it work?
    //TODO Rename Thread, conflict with java.Lang.Thread
    public void save() {
        LOG.log(Level.INFO, "Save {0}" + postBB);
        ForumThread thread = nav.getThread();
        thread.addPost(new Post(postBB.getContent(), login.getUser()));
        forum.getThreadCatalogue().update(thread);
    }
}