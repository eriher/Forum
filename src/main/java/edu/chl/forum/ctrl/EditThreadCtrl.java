/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.chl.forum.ctrl;

import edu.chl.forum.core.ForumThread;
import edu.chl.forum.core.IForum;
import edu.chl.forum.view.EditThreadBB;
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
 * @author erikk
 * Handles saving for edited threads
 */
@Named
@RequestScoped
public class EditThreadCtrl {
    private static final Logger LOG = Logger.getLogger(EditThreadCtrl.class.getName());
    @Inject IForum forum;
    @Inject Navigation nav;
    @Inject EditThreadBB editThreadBB;
    
    @PostConstruct
    public void post() {
        LOG.log(Level.INFO, "EditThreadCtrl alive {0}", this);
    }
    
    @PreDestroy
    public void pre() {
        LOG.log(Level.INFO, "EditThreadCtrl to be destroyed {0}", this);
    }
    
    public void save () {
        ForumThread thread = nav.getThread();
        thread.setTitle(editThreadBB.getTitle());
        thread.setLocked(editThreadBB.isLocked());
        forum.getThreadCatalogue().update(thread);
    }
}
