/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.chl.forum.ctrl;

import edu.chl.forum.core.IForum;
import edu.chl.forum.core.MainTopic;
import edu.chl.forum.core.SubTopic;
import edu.chl.forum.view.AddSubTopicBB;
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
public class AddSubTopicCtrl {
    @Inject AddSubTopicBB addSubTopicBB;
    @Inject IForum forum;
    @Inject Navigation nav;
    
    private static final Logger LOG = Logger.getLogger(AddSubTopicCtrl.class.getName());
    
    @PostConstruct
    public void post() {
        LOG.log(Level.INFO, "AddSubTopicCtrl alive {0}", this);
    }
    
    @PreDestroy
    public void pre() {
        LOG.log(Level.INFO, "AddSubTopicCtrl to be destroyed {0}", this);
    }
    
    public void save() {
        MainTopic maintopic  = nav.getMaintopic();
        maintopic.addSubTopic(new SubTopic(addSubTopicBB.getTitle() ,addSubTopicBB.getDescription(), null));
        forum.getMainTopicCatalogue().update(maintopic);
    }
}
