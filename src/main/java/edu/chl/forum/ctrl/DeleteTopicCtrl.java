/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.chl.forum.ctrl;

import edu.chl.forum.core.IForum;
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
 * Handles deletion of Topics, uses forum, used by index.xhmtl
 */
 @Named
 @RequestScoped
public class DeleteTopicCtrl {
    private static final Logger LOG = Logger.getLogger(DeleteTopicCtrl.class.getName());
    @Inject IForum forum;
    @PostConstruct
    public void post() {
        LOG.log(Level.INFO, "DeleteCtrl alive {0}", this);
    }
    
    @PreDestroy
    public void pre() {
        LOG.log(Level.INFO, "DeleteCtrl to be destroyed {0}", this);
    }
    public void deleteSubTopic(Long id) {
        forum.getSubTopicCatalogue().delete(id);
    }
    public void deleteMainTopic(Long id){
        forum.getMainTopicCatalogue().delete(id);
    }
}
