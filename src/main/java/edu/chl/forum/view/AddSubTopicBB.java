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
 * @author erik
 */
@Named
@RequestScoped
public class AddSubTopicBB {
    private String title;
    private String description;
    private static final Logger LOG = Logger.getLogger(AddSubTopicBB.class.getName());
    
    @PostConstruct
    public void post() {
        LOG.log(Level.INFO, "AddSubTopicBB alive {0}", this);
    }
    
    @PreDestroy
    public void pre() {
        LOG.log(Level.INFO, "AddSubTopicBB to be destroyed {0}", this);
    }
    
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}