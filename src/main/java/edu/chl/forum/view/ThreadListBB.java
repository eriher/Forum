/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.chl.forum.view;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;


/**
 *
 * @author erik
 */
@ManagedBean
@ViewScoped
public class ThreadListBB implements Serializable {

    private static final Logger LOG = Logger.getLogger(ThreadListBB.class.getName()); 
    //private List<Thread> threads;
    private List<String> threads;
         
    
    @PostConstruct
    public void init() {
        LOG.log(Level.INFO, "ThreadListBB alive {0}", this);
        //threads = forum.getThreadCatalogue().findbynånting();
        threads = new ArrayList<>();
        for(int i=0;i<10;i++){
            threads.add("Thread"+Integer.toString(i));
        }
    }
 
    public List<String> getThreads() {
        return threads;
    }
    
}
