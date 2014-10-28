/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.chl.forum.view;

import edu.chl.forum.core.SubTopic;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

/**
 *
 * @author erikk
 */
@Named
@RequestScoped
public class AddTopicBB {
    
    private String title;
    private String description;
    private List<SubTopic> subtopics;
    
    private static final Logger LOG = Logger.getLogger(AddTopicBB.class.getName());
    
    @PostConstruct
    public void post() {
        LOG.log(Level.INFO, "AddTopicBB alive {0}", this);
    }
    
    @PreDestroy
    public void pre() {
        LOG.log(Level.INFO, "AddTopicBB to be destroyed {0}", this);
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

    public List<SubTopic> getSubtopics() {
        return subtopics;
    }

    public void setSubtopics(List<SubTopic> subtopics) {
        this.subtopics = subtopics;
    }
}
