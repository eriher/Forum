/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package edu.chl.forum.view;

import edu.chl.forum.core.IForum;
import edu.chl.forum.core.MainTopic;
import edu.chl.forum.core.SubTopic;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;
import org.primefaces.component.accordionpanel.AccordionPanel;

/**
 *
 * @author erik
 */
@Named
@SessionScoped
public class TopicsListBB implements Serializable{
        private static final Logger LOG = Logger.getLogger(TopicsListBB.class.getName()); 
        private List<MainTopic> maintopics;
        private List<SubTopic> subtopics;
        private List<String> strings;
        @Inject IForum forum;
        private String tabs;        
        
        @PostConstruct
        public void init() {
            
            LOG.log(Level.INFO, "TopicsListBB alive {0}", this);
                    subtopics = new ArrayList();
                    subtopics.add(new SubTopic("Subtopic 1","context",null));
                    subtopics.add(new SubTopic("Subtopic 2","context",null));
                    forum.getMainTopicCatalogue().create(new MainTopic("Test1",subtopics));
                    subtopics = new ArrayList();
                    subtopics.add(new SubTopic("Subtopic 1","context",null));
                    subtopics.add(new SubTopic("Subtopic 2","context",null));
                    subtopics.add(new SubTopic("Subtopic 3","context",null));
                    subtopics.add(new SubTopic("Subtopic 4","context",null));
                    forum.getMainTopicCatalogue().create(new MainTopic("Test2",subtopics));
                    subtopics = new ArrayList();
                    subtopics.add(new SubTopic("Subtopic 1","context",null));
                    subtopics.add(new SubTopic("Subtopic 2","context",null));
                    subtopics.add(new SubTopic("Subtopic 3","context",null));
                    subtopics.add(new SubTopic("Subtopic 4","context",null));
                    subtopics.add(new SubTopic("Subtopic 5","context",null));
                    subtopics.add(new SubTopic("Subtopic 6","context",null));
                    forum.getMainTopicCatalogue().create(new MainTopic("Test3",subtopics));
                    maintopics = forum.getMainTopicCatalogue().findAll();
                    setActiveTabs(forum.getMainTopicCatalogue().count());
                    System.out.println(tabs);
            System.out.println(forum.getMainTopicCatalogue().count());
            //subtopics = maintopics.get(0).getList();
        }
        public List<MainTopic> getmaintopics() {
            return maintopics;
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
