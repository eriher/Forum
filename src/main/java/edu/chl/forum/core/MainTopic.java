/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package edu.chl.forum.core;

import edu.chl.forum.util.AbstractEntity;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Olof
 */
public class MainTopic extends AbstractEntity {
    
    private String name;
    private List<SubTopic> subTopics;
    
    public MainTopic(String name, List<SubTopic> list){
        this.name = name;
        this.subTopics = list;
    }
    
    public MainTopic(Long id, String name, List<SubTopic> list){
        super(id);
        this.name = name;
        this.subTopics = list;
    }
    
    public String getName(){
        return name;
    }
    
    public List<SubTopic> getList(){
        return subTopics;
    }
     
    public boolean addSubTopic(SubTopic topic){
        return subTopics.add(topic);
    }
}
