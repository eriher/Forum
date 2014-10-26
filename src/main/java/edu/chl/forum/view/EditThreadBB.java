/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.chl.forum.view;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

/**
 *
 * @author erikk
 * Handles data for editing of threads
 */
@Named
@RequestScoped
public class EditThreadBB {
    
    private String title;
    private boolean locked;
    private static final Logger LOG = Logger.getLogger(EditThreadBB.class.getName());
    
    @PostConstruct
    public void post() {
        LOG.log(Level.INFO, "EditThreadBB alive {0}", this);
    }
    
    @PreDestroy
    public void pre() {
        LOG.log(Level.INFO, "EditThreadBB to be destroyed {0}", this);
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public boolean isLocked() {
        return locked;
    }

    public void setLocked(boolean locked) {
        this.locked = locked;
    }
    
    
    
}
