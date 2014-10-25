/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.chl.forum.view;


import edu.chl.forum.core.ForumThread;
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
    
        
    @PostConstruct
    public void init() {
        LOG.log(Level.INFO, "NavigationBB alive {0}", this);
    }
    @PreDestroy
    public void pre() {
        LOG.log(Level.INFO, "NavigationBB to be destroyed {0}", this);
    }
    
    public NavigationBB() {
        model = new DefaultMenuModel();
        
        DefaultMenuItem item = new DefaultMenuItem("home");
        item.setCommand("#{navigationBB.navigateHome}");
        model.addElement(item);
    }
    
    public MenuModel getModel() {
        return model;
    }    
    public String navigateHome() {
        model = new DefaultMenuModel();
        
        DefaultMenuItem home = new DefaultMenuItem("home");
        home.setCommand("#{navigationBB.navigateHome}");
        model.addElement(home);
        LOG.log(Level.INFO, "navigate home", this);
        return "home";
    }
    
    public String navigateThreads(){
        model = new DefaultMenuModel();
        
        DefaultMenuItem home = new DefaultMenuItem("home");
        home.setCommand("#{navigationBB.navigateHome}");
        model.addElement(home);
                       
        DefaultMenuItem threads = new DefaultMenuItem();
        threads.setValue(subtopic.getTitle());
        threads.setCommand("#{navigationBB.navigateThreads}");
        this.model.addElement(threads);
        LOG.log(Level.INFO, "navigate threads", this);
        return "threads";
    }
    public String navigatePosts(){
        model = new DefaultMenuModel();
        
        DefaultMenuItem home = new DefaultMenuItem("home");
        home.setCommand("#{navigationBB.navigateHome}");
        model.addElement(home);
                       
        DefaultMenuItem threads = new DefaultMenuItem();
        threads.setValue(subtopic.getTitle());
        threads.setCommand("#{navigationBB.navigateThreads()}");
        this.model.addElement(threads);
        
        DefaultMenuItem posts = new DefaultMenuItem();
        posts.setValue(thread.getTitle());
        posts.setCommand("#{navigationBB.navigatePosts}");
        this.model.addElement(posts);
        LOG.log(Level.INFO, "navigate posts", this);
        
        return "posts";
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

}
