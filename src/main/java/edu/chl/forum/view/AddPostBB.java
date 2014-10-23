/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.chl.forum.view;

import edu.chl.forum.auth.ForumUser;
import java.io.Serializable;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

/**
 *
 * @author erik
 */
@Named
@RequestScoped
public class AddPostBB implements Serializable {
    
    private String content;
    private Date date = new Date();
    private ForumUser user = new ForumUser();
    private static final Logger LOG = Logger.getLogger(AddPostBB.class.getName());
    
    @PostConstruct
    public void post() {
        LOG.log(Level.INFO, "AddPostBB alive {0}", this);
    }
    
    @PreDestroy
    public void pre() {
        LOG.log(Level.INFO, "AddPostBB to be destroyed {0}", this);
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

    public void setContent(String content) {
        this.content = content;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public void setUser(ForumUser user) {
        this.user = user;
    }
    
}
