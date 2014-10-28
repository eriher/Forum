/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.chl.forum.ctrl;

import edu.chl.forum.core.IForum;
import edu.chl.forum.core.MainTopic;
import edu.chl.forum.view.AddTopicBB;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

/**
 *
 * @author erikk
 */
@Named
@RequestScoped
public class AddTopicCtrl {
    @Inject AddTopicBB addtopicBB;
    @Inject IForum forum;
    
    private static final Logger LOG = Logger.getLogger(AddTopicCtrl.class.getName());
    
    @PostConstruct
    public void post() {
        LOG.log(Level.INFO, "AddTopicCtrl alive {0}", this);
    }
    
    @PreDestroy
    public void pre() {
        LOG.log(Level.INFO, "AddTopicCtrl to be destroyed {0}", this);
    }
    
    public void save() {
        MainTopic maintopic = new MainTopic(addtopicBB.getTitle() ,addtopicBB.getDescription(), addtopicBB.getSubtopics());
        forum.getMainTopicCatalogue().create(maintopic);
    }
}
