/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package edu.chl.forum.view;

import edu.chl.forum.core.Forum;
import edu.chl.forum.core.IForum;
import edu.chl.forum.core.MainTopic;
import edu.chl.forum.core.SubTopic;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.annotation.PostConstruct;
import javax.inject.Inject;

/**
 *
 * @author erik
 */
@ManagedBean
@ViewScoped
public class TopicsListBB implements Serializable{
        private static final Logger LOG = Logger.getLogger(TopicsListBB.class.getName()); 
        private List<MainTopic> maintopics;
        private List<SubTopic> subtopics;
        private List<String> strings;
        @Inject private IForum forum;
        
        
        @PostConstruct
        public void init() {
            
            LOG.log(Level.INFO, "TopicsListBB alive {0}", this);
            //maintopics = forum.getMainTopicCatalogue().findAll();
            //System.out.println(maintopics.size());
            //subtopics = maintopics.get(0).getList();
        }
        public List<String> getStrings() {
            return strings;
        }
    
}
