/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.chl.forum.util;


import edu.chl.forum.core.ForumThread;
import edu.chl.forum.core.MainTopic;
import edu.chl.forum.core.SubTopic;
import java.io.Serializable;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import org.primefaces.model.menu.DefaultMenuItem;
import org.primefaces.model.menu.DefaultMenuModel;
import org.primefaces.model.menu.MenuModel;

/**
 *
 * @author erik
 * Contains models for Breadcrumb navigation
 * Keeps track refrences for web pages and ctrl beans
 * Used by: index,postlist,threadlist,add/edit.xhml, 
 * Used by: EditTopicCtrl,EditThreadCtrl,EditPostCtrl,AddThreadCtrl,
 * Used by: AddSubTopicCtrl,AddPostCtrl
 */
@Named
@SessionScoped
public class Navigation implements Serializable{
    private static final Logger LOG = Logger.getLogger(Navigation.class.getName()); 
    private MenuModel model;
    private ForumThread thread;
    private SubTopic subtopic;
    private MainTopic maintopic;
    
        
    @PostConstruct
    public void init() {
        LOG.log(Level.INFO, "Navigation alive {0}", this);
    }
    @PreDestroy
    public void pre() {
        LOG.log(Level.INFO, "Navigation to be destroyed {0}", this);
    }    
    public MenuModel getModel() {
        return model;
    }    
    public MenuModel navigateHome() {
        model = new DefaultMenuModel();
        
        DefaultMenuItem home = new DefaultMenuItem("home");
        home.setOutcome("home");
        model.addElement(home);
        return  model;
    }
    
    public MenuModel navigateThreads(){
        model = new DefaultMenuModel();
        
        DefaultMenuItem home = new DefaultMenuItem("home");
        home.setOutcome("home");
        model.addElement(home);
                       
        DefaultMenuItem threads = new DefaultMenuItem();
        threads.setValue(subtopic.getTitle());
        threads.setOutcome("threads");
        this.model.addElement(threads);
        
        return  model;
    }
    public MenuModel navigatePosts(){
        model = new DefaultMenuModel();
        
        DefaultMenuItem home = new DefaultMenuItem("home");
        home.setOutcome("home");
        model.addElement(home);
                       
        DefaultMenuItem threads = new DefaultMenuItem();
        threads.setValue(subtopic.getTitle());
        threads.setOutcome("threads");
        this.model.addElement(threads);
        
        DefaultMenuItem posts = new DefaultMenuItem();
        posts.setValue(thread.getTitle());
        posts.setOutcome("posts");
        this.model.addElement(posts);
        
        return model;
    }

    public ForumThread getThread() {
        return thread;
    }

    public void setThread(ForumThread thread) {
        this.thread = thread;
    }

    public SubTopic getSubtopic() {
        return subtopic;
    }

    public void setSubtopic(SubTopic subtopic) {
        this.subtopic = subtopic;
    }

    public MainTopic getMaintopic() {
        return maintopic;
    }

    public void setMaintopic(MainTopic maintopic) {
        this.maintopic = maintopic;
    }
    

}
