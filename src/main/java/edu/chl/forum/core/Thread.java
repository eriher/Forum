/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package edu.chl.forum.core;

import edu.chl.forum.auth.User;
import edu.chl.forum.util.AbstractEntity;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author Olof
 */
@Entity
public class Thread extends AbstractEntity{
    
    @OneToOne
    private User user;
    private String title;
    private String content;
    
    @Temporal(TemporalType.DATE)
    private  Date date = new Date();
    
    @OneToMany
    private List<Post> posts = new ArrayList();

    public Thread() {
    }
    
    public Thread(String name, Post post){
        this.title = name;
        posts.add(post);
    }
    
    public Thread(Long id, String name, Post post){
        super(id);
        this.title = name;
        posts.add(post);
    }
    
    public boolean addPost(Post post) {
        return posts.add(post);
    }
    
    public String getTitle(){
        return title;
    }
    
     public User getUser() {
        return user;
    }

    public String getContent() {
        return content;
    }

    public Date getDate() {
        return date;
    }

    public List<Post> getPosts() {
        return posts;
    }
}
