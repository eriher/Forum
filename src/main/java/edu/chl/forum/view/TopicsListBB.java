/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package edu.chl.forum.view;

import edu.chl.forum.auth.ForumUser;
import edu.chl.forum.core.ForumThread;
import edu.chl.forum.core.IForum;
import edu.chl.forum.core.MainTopic;
import edu.chl.forum.core.Post;
import edu.chl.forum.core.SubTopic;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
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
public class TopicsListBB implements Serializable{
        private static final Logger LOG = Logger.getLogger(TopicsListBB.class.getName()); 
        @Inject IForum forum;
        private String tabs;
        
        private List<MainTopic> maintopics;
        private List<SubTopic> subtopics;
        private List<String> strings;
        private List<ForumThread> threads;

        
        @PostConstruct
        public void init() {
            LOG.log(Level.INFO, "TopicsListBB alive {0}", this);   
            
            
            maintopics = forum.getMainTopicCatalogue().findAll();
            if(forum.getMainTopicCatalogue().count() == 0)
            {
                    subtopics = new ArrayList();
                    subtopics.add(new SubTopic("Subtopic 1","context",null));
                    subtopics.add(new SubTopic("Subtopic 2","context",null));
                    forum.getMainTopicCatalogue().create(new MainTopic("Title1", "descr",subtopics));
                    subtopics = new ArrayList();
                    subtopics.add(new SubTopic("Subtopic 1","context",null));
                    subtopics.add(new SubTopic("Subtopic 2","context",null));
                    subtopics.add(new SubTopic("Subtopic 3","context",null));
                    subtopics.add(new SubTopic("Subtopic 4","context",null));
                    forum.getMainTopicCatalogue().create(new MainTopic("Title2","descr",subtopics));
                    subtopics = new ArrayList();
                    subtopics.add(new SubTopic("Subtopic 1","context",null));
                    subtopics.add(new SubTopic("Subtopic 2","context",null));
                    subtopics.add(new SubTopic("Subtopic 3","context",null));
                    subtopics.add(new SubTopic("Subtopic 4","context",null));
                    subtopics.add(new SubTopic("Subtopic 5","context",null));
                    subtopics.add(new SubTopic("Subtopic 6","context",null));
                    forum.getMainTopicCatalogue().create(new MainTopic("Title3","descr",subtopics));
                    
                    maintopics = forum.getMainTopicCatalogue().findAll();
                    ForumUser user = new ForumUser("Pelle");
                    maintopics.get(0).getList().get(0).getList().add(new ForumThread("threadtest1",new Post("this is a test post",user),user));
                    forum.getMainTopicCatalogue().update(maintopics.get(0));
            }

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
