/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package edu.chl.forum.view;


import edu.chl.forum.core.IForum;
import edu.chl.forum.core.MainTopic;
import java.io.Serializable;
import java.util.List;
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
 * Handles the view for Main and SubTopics, uses IForum, used by index.xhtml
 */
@Named
@ViewScoped
public class TopicsListBB implements Serializable{
        private static final Logger LOG = Logger.getLogger(TopicsListBB.class.getName()); 
        private IForum forum;
        private String tabs;
        private List<MainTopic> maintopics;
        
        public TopicsListBB() {
        }
        
        @Inject
        public TopicsListBB(IForum forum) {
            this.forum = forum;
        }
        
        @PostConstruct
        public void init() {
            LOG.log(Level.INFO, "TopicsListBB alive {0}", this);
            maintopics = forum.getMainTopicCatalogue().findAll();
            setActiveTabs(forum.getMainTopicCatalogue().count());
        }
        
        @PreDestroy
        public void pre() {
            LOG.log(Level.INFO, "TopicsListBB to be destroyed {0}", this);
        }

        
        public void settabs(String tabs) {
            this.tabs = tabs;
        }
        
        public String getTabs() {
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

        public List<MainTopic> getMaintopic() {
            return maintopics;
        }

        public void setMaintopic(List<MainTopic> maintopic) {
            this.maintopics = maintopic;
        }
}
