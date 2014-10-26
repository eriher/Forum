/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package edu.chl.forum.core;

import edu.chl.forum.persistence.AbstractEntity;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

/**
 *
 * @author Olof
 */
@Entity


public class SubTopic extends AbstractEntity{
    
    private String title;
    private String description;
    @OneToMany(cascade= CascadeType.ALL, orphanRemoval=true)
    @JoinColumn(name = "SUBTOPIC_ID")
    private List<ForumThread> threads;
    private boolean locked;
    
    
    public SubTopic() {
        
    }
    public SubTopic(String name, String description){
        this.title = name;
        this.description = description;
        threads = new ArrayList();
        locked = false;
    }
    
    public SubTopic(String name, String description, List<ForumThread> list){
        this.title = name;
        this.description = description;
        this.threads = list;
        locked = false;
    }
    
    public SubTopic(Long id, String name, List<ForumThread> list){
        super(id);
        this.title = name;
        this.threads = list;
        locked = false;
    }
    

    public String getTitle(){
        return title;
    }
    
    public List<ForumThread> getList(){
        return threads;
    }
    
    public void addThread(ForumThread thread) {
        threads.add(0, thread);
    }
    
    public String getDescription() {
        return description;
    }

    public boolean isLocked() {
        return locked;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setLocked(boolean locked) {
        this.locked = locked;
    }
    
    
}
