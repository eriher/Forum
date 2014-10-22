/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package edu.chl.forum.core;

import edu.chl.forum.util.AbstractEntity;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;

/**
 *
 * @author Olof
 */
@Entity


public class SubTopic extends AbstractEntity{

    private String title;
    private String description;
    @OneToMany(cascade=CascadeType.PERSIST)
    private List<Thread> threads;
    
    
    public SubTopic() {
        
    }
    
    public SubTopic(String name, String description, List<Thread> list){
        this.title = name;
        this.description = description;
        this.threads = list;
    }
    
    public SubTopic(Long id, String name, List<Thread> list){
        super(id);
        this.title = name;
        this.threads = list;
    }
    

    public String getTitle(){
        return title;
    }
    
    public List<Thread> getList(){
        return threads;
    }
    
    public boolean addThread(Thread thread) {
        return threads.add(thread);
    }
    
    public String getDescription() {
        return description;
    }
}
