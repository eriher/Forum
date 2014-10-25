/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.chl.forum.view;


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
 */
@Named
@SessionScoped
public class NavigationBB implements Serializable{
    private static final Logger LOG = Logger.getLogger(NavigationBB.class.getName()); 
    private MenuModel model;
    private ForumThread thread;
    private SubTopic subtopic;
    private MainTopic maintopic;
    
        
    @PostConstruct
    public void init() {
        LOG.log(Level.INFO, "NavigationBB alive {0}", this);
    }
    @PreDestroy
    public void pre() {
        LOG.log(Level.INFO, "NavigationBB to be destroyed {0}", this);
    }    
    public MenuModel getModel() {
        return model;
    }    
    public MenuModel navigateHome() {
        model = new DefaultMenuModel();
        
        DefaultMenuItem home = new DefaultMenuItem("home");
        home.setOutcome("home");
        model.addElement(home);
        LOG.log(Level.INFO, "navigate home", this);
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
