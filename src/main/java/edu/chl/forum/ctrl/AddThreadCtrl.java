/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.chl.forum.ctrl;

import edu.chl.forum.auth.LoginBean;
import edu.chl.forum.core.ForumThread;
import edu.chl.forum.core.IForum;
import edu.chl.forum.core.Post;
import edu.chl.forum.core.SubTopic;
import edu.chl.forum.view.AddThreadBB;
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
 */
@Named
@RequestScoped
public class AddThreadCtrl {
    
    @Inject AddThreadBB addThreadBB;
    @Inject IForum forum;
    @Inject Navigation nav;
    @Inject LoginBean login;
    
    private static final Logger LOG = Logger.getLogger(AddThreadCtrl.class.getName());
    
    @PostConstruct
    public void post() {
        LOG.log(Level.INFO, "AddThreadCtrl alive {0}", this);
    }
    
    @PreDestroy
    public void pre() {
        LOG.log(Level.INFO, "AddThreadCtrl to be destroyed {0}", this);
    }
    
    public void save(){
        SubTopic subTopic = nav.getSubtopic();
        subTopic.addThread(new ForumThread(addThreadBB.getTitle(), new Post(addThreadBB.getContent(), login.getUser()), login.getUser()));
        forum.getSubTopicCatalogue().update(subTopic);
    }
}
