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
public class SubTopic extends AbstractEntity {
    
    private String name;
    private List<Thread> threads;
    
    public SubTopic(String name, List<Thread> list){
        this.name = name;
        this.threads = list;
    }
    
    public SubTopic(Long id, String name,List<Thread> list){
        super(id);
        this.name = name;
        this.threads = list;
    }
    
    public String getName(){
        return name;
    }
    
    public List<Thread> getList(){
        return threads;
    }
    
    public boolean addThread(Thread thread) {
        return threads.add(thread);
    }
}
