/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package edu.chl.forum.core;

import edu.chl.forum.auth.ForumUser;
import edu.chl.forum.util.AbstractEntity;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
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
    
    @ManyToOne
    private ForumUser user;
    private String title;
    private String content;
    
    @Temporal(TemporalType.DATE)
    private  Date date = new Date();
    
    @OneToMany
    private List<Post> posts = new ArrayList();

    public Thread() {
    }
    
    public Thread(String title, Post post){
        this.title = title;
        posts.add(post);
    }
    
    public Thread(Long id, String title, Post post){
        super(id);
        this.title = title;
        posts.add(post);
    }
    
    public boolean addPost(Post post) {
        return posts.add(post);
    }
    
    public String getTitle(){
        return title;
    }
    
     public ForumUser getUser() {
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
