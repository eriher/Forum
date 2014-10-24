/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.chl.forum.ctrl;

import edu.chl.forum.core.Forum;
import edu.chl.forum.core.IForum;
import edu.chl.forum.core.Post;
import edu.chl.forum.core.SingletonForum;
import edu.chl.forum.view.EditPostBB;
import edu.chl.forum.view.TopicsListBB;
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
public class EditPostCtrl {
    
    private EditPostBB postBB;
    private static final Logger LOG = Logger.getLogger(EditPostCtrl.class.getName());
    private IForum forum;
    private TopicsListBB listBB;
    
    
    protected EditPostCtrl(){
        
    }
    
    @PostConstruct
    public void post() {
        LOG.log(Level.INFO, "EditPostCtrl alive {0}", this);
    }
    
    @PreDestroy
    public void pre() {
        LOG.log(Level.INFO, "EditPostCtrl to be destroyed {0}", this);
    }
    
    @Inject
    public EditPostCtrl(IForum forum){
        this.forum = forum;
    } 
    
    @Inject
    public void setPostBB(EditPostBB postBB){
        this.postBB = postBB;
    }
    
    @Inject
    public void setTopicsList(TopicsListBB listBB){
        this.listBB = listBB;
    }
  
    //TODO Rename Thread, conflict with java.Lang.Thread
    public void save() {
        LOG.log(Level.INFO, "Save {0}" + postBB);
        
        //TODO Every post need serverside ID(Inside thread only) listBB.getCurrentThread().getList().size();??
        listBB.getCurrentThread().getList().get(postBB.getIndex()).setContent(postBB.getContent());
        forum.getThreadCatalogue().update(listBB.getCurrentThread());
    }
}
