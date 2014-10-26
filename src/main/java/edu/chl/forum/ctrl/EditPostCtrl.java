/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.chl.forum.ctrl;

import edu.chl.forum.auth.ForumUser;
import edu.chl.forum.core.IForum;
import edu.chl.forum.core.Post;
import edu.chl.forum.view.EditPostBB;
import edu.chl.forum.view.NavigationBB;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
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
public class EditPostCtrl {
    
    private EditPostBB postBB;
    private static final Logger LOG = Logger.getLogger(EditPostCtrl.class.getName());
    private IForum forum;
    @Inject NavigationBB nav;
    
    
    protected EditPostCtrl(){
        
    }
    
    @PostConstruct
    public void post() {
        LOG.log(Level.INFO, "EditPostCtrl alive {0}", this);
    }
    
    @PreDestroy
    public void pre() {
        LOG.log(Level.INFO, "EditPostCtrl to be destroyed {0}", this);
    }
    
    @Inject
    public EditPostCtrl(IForum forum){
        this.forum = forum;
    } 
    
    @Inject
    public void setPostBB(EditPostBB postBB){
        this.postBB = postBB;
    }
    
  
    //TODO Rename Thread, conflict with java.Lang.Thread
    public void save() {
        LOG.log(Level.INFO, "Save {0}" + postBB);
        
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        Date today = new Date();
        String date = df.format(today);
        
        Post post = nav.getThread().getList().get(postBB.getIndex());
        post.setContent(postBB.getContent());
        
        ForumUser user = forum.getUserCatalogue().find(postBB.getEditorId());
        if(user.getRank()<1)
        {
            post.setEditText("Edited on " +date+ " by user " +user.getName());
            post.setUserEdit(true);
        }
        else{
            post.setEditText("Edited on " +date+ " by administrator " +user.getName());
            post.setAdminEdit(true);
        }
        forum.getPostCatalogue().update(post);
    }
}
