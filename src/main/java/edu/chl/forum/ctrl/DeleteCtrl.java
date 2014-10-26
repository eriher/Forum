/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.chl.forum.ctrl;

import edu.chl.forum.core.IForum;
import edu.chl.forum.core.MainTopic;
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
public class DeleteCtrl {
    private static final Logger LOG = Logger.getLogger(DeleteCtrl.class.getName());
    @Inject IForum forum;
    @PostConstruct
    public void post() {
        LOG.log(Level.INFO, "DeleteCtrl alive {0}", this);
    }
    
    @PreDestroy
    public void pre() {
        LOG.log(Level.INFO, "DeleteCtrl to be destroyed {0}", this);
    }
    public void deleteSubTopic(Long id, int index, MainTopic maintopic) {
        forum.getSubTopicCatalogue().delete(id);
        maintopic.getList().get(index);
        forum.getMainTopicCatalogue().update(maintopic);
    }
    public void deleteMainTopic(Long id){
        forum.getMainTopicCatalogue().delete(id);
    }
}
