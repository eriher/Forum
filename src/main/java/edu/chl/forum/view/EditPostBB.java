/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.chl.forum.view;

import edu.chl.forum.auth.ForumUser;
import edu.chl.forum.core.Post;
import java.io.Serializable;
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
 * @author olof
 */
@Named
@RequestScoped
public class EditPostBB implements Serializable {
   
    private int index;
    private Post post;
    private String content;
    private Date date = new Date();
    private ForumUser user;
    private static final Logger LOG = Logger.getLogger(AddPostBB.class.getName());
    
    @PostConstruct
    public void post() {
        LOG.log(Level.INFO, "EditPostBB alive {0}", this);
    }
    
    @PreDestroy
    public void pre() {
        LOG.log(Level.INFO, "EditPostBB to be destroyed {0}", this);
    }
    
    public String getContent() {
        return content;
    }

    public Date getDate() {
        return date;
    }

    public ForumUser getUser() {
        return user;
    }
    
    public int getIndex(){
        return index;
    }
    
    public Post getPost(){
        return post;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public void setUser(ForumUser user) {
        this.user = user;
    }
    
    public void setIndex(int index){
        this.index = index;
    }
    
    
    
}
