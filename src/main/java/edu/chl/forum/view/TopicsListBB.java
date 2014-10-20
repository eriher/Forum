/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package edu.chl.forum.view;

import edu.chl.forum.core.MainTopic;
import edu.chl.forum.core.SubTopic;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
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
public class TopicsListBB implements Serializable{
        private static final Logger LOG = Logger.getLogger(ThreadListBB.class.getName()); 
        private List<MainTopic> maintopics;
        private List<SubTopic> subtopics;
        
    @PostConstruct
    public void init() {
        maintopics = new ArrayList();
        maintopics.add(new MainTopic("TestTopic 1",null));
    }
    
}
