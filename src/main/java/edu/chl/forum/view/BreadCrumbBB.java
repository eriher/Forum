/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.chl.forum.view;


import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import org.primefaces.model.menu.DefaultMenuItem;
import org.primefaces.model.menu.DefaultMenuModel;
import org.primefaces.model.menu.MenuModel;

/**
 *
 * @author erik
 */
@ManagedBean
@SessionScoped
public class BreadCrumbBB {
    
    private static final Logger LOG = Logger.getLogger(BreadCrumbBB.class.getName()); 
    private MenuModel model;
    
        
    @PostConstruct
    public void init() {
        LOG.log(Level.INFO, "BreadCrumbBean alive {0}", this);
    }
    
    public BreadCrumbBB() {
        model = new DefaultMenuModel();
        
        DefaultMenuItem item = new DefaultMenuItem();
        item.setValue("Topics");
        item.setCommand("#{breadCrumbBB.navigateHome}");
        item.setOutcome("home");
        model.addElement(item);
    }
    
    public MenuModel getModel() {
        return model;
    }
    
    public String navigateHome() {
        model = new DefaultMenuModel();
        
        DefaultMenuItem home = new DefaultMenuItem();
        home.setValue("Topics");
        home.setCommand("#{breadCrumbBB.navigateHome}");
        home.setOutcome("home");
        model.addElement(home);
        LOG.log(Level.INFO, "navigate home", this);
        return "home";
    }
    
    public String navigateThreads(){
        model = new DefaultMenuModel();
        
        DefaultMenuItem home = new DefaultMenuItem();
        home.setValue("Topics");
        home.setCommand("#{breadCrumbBB.navigateHome}");
        home.setOutcome("home");
        model.addElement(home);
                       
        DefaultMenuItem threads = new DefaultMenuItem();
        threads.setValue("Threads");
        threads.setCommand("#{breadCrumbBB.navigateThreads}");
        threads.setOutcome("threads");
        this.model.addElement(threads);
        return "threads";
    }

    
}
