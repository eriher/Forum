/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package edu.chl.forum.core;

import edu.chl.forum.util.AbstractEntity;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;

/**
 *
 * @author Olof
 */
@Entity
public class MainTopic extends AbstractEntity {
    
    private String title;
    private String description;
    @OneToMany(cascade=CascadeType.ALL)
    private List<SubTopic> subTopics;
    
    
    public MainTopic() {
        
    }
    
    public MainTopic(String title, String description, List<SubTopic> list){
        this.title = title;
        this.description = description;
        this.subTopics = list;
    }
    
    public MainTopic(Long id, String title, String description, List<SubTopic> list){
        super(id);
        this.title = title;
        this.description = description;
        this.subTopics = list;
    }
    
    public String getTitle(){
        return title;
    }
    
    public List<SubTopic> getList(){
        return subTopics;
    }
    
    public String getDescription(){
        return description;
    }
     
    public boolean addSubTopic(SubTopic topic){
        return subTopics.add(topic);
    }
}
