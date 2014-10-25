/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package edu.chl.forum.view;

import edu.chl.forum.core.IForum;
import java.io.Serializable;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

/**
 *
 * @author erik
 */
@Named
@ViewScoped
public class TopicsListBB implements Serializable{
        private static final Logger LOG = Logger.getLogger(TopicsListBB.class.getName()); 
        @Inject IForum forum;
        private String tabs;

        
        @PostConstruct
        public void init() {
            LOG.log(Level.INFO, "TopicsListBB alive {0}", this);                     
            setActiveTabs(forum.getMainTopicCatalogue().count());
        }
        
        @PreDestroy
        public void pre() {
            LOG.log(Level.INFO, "TopicsListBB to be destroyed {0}", this);
        }
        
        public IForum getForum() {
            return forum;
        }

        
        public void settabs(String tabs) {
            this.tabs = tabs;
        }
        public String gettabs() {
            return tabs;
        }

        
        private void setActiveTabs(int count) {
            tabs = new String();
            for(int i = 0;i<count;i++){
                if(i==0)
                tabs = Integer.toString(i);
                else
                tabs = tabs + "," + Integer.toString(i);
            }       
        }
    
}
