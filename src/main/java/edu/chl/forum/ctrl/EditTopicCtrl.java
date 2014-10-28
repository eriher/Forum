/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.chl.forum.ctrl;

import edu.chl.forum.core.IForum;
import edu.chl.forum.core.MainTopic;
import edu.chl.forum.core.SubTopic;
import edu.chl.forum.view.EditTopicBB;
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
 * Handles saving for sub/maintopics
 */
@Named
@RequestScoped
public class EditTopicCtrl {
    
    private static final Logger LOG = Logger.getLogger(EditTopicCtrl.class.getName());
    @Inject IForum forum;
    @Inject Navigation nav;
    @Inject EditTopicBB editTopicBB;
    @PostConstruct
    
    public void post() {
        LOG.log(Level.INFO, "EditCtrl alive {0}", this);
    }
    
    @PreDestroy
    public void pre() {
        LOG.log(Level.INFO, "EditCtrl to be destroyed {0}", this);
    }
    
    public void saveSubtopic() {
        SubTopic subTopic = nav.getSubtopic();
        subTopic.setDescription(editTopicBB.getDescription());
        subTopic.setTitle(editTopicBB.getTitle());
        subTopic.setLocked(editTopicBB.isLocked());
        forum.getSubTopicCatalogue().update(subTopic);
    }
    public void saveMainTopic() {
        MainTopic maintopic = nav.getMaintopic();
        maintopic.setDescription(editTopicBB.getDescription());
        maintopic.setTitle(editTopicBB.getTitle());
        maintopic.setLocked(editTopicBB.isLocked());
        forum.getMainTopicCatalogue().update(maintopic);
    }
}
