/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package edu.chl.forum.core;

import edu.chl.forum.util.AbstractEntity;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.OneToMany;

/**
 *
 * @author Olof
 */
@Entity
public class Thread extends AbstractEntity{
    
    private String name;
    @OneToMany
    private List<Post> posts = new ArrayList();

    public Thread() {
    }
    
    public Thread(String name, Post post){
        this.name = name;
        posts.add(post);
    }
    
    public Thread(Long id, String name, Post post){
        super(id);
        this.name = name;
        posts.add(post);
    }
    
    public String getName() {
        return name;
    }
    
    public List<Post> getList(){
        return posts;
    }
    
    public boolean addPost(Post post) {
        return posts.add(post);
    }
}
