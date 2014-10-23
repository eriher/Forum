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
public class ForumThread extends AbstractEntity{
    
    @ManyToOne
    private ForumUser user;
    private String title;
    
    @Temporal(TemporalType.DATE)
    private  Date date = new Date();
    
    @OneToMany
    private List<Post> posts = new ArrayList();

    public ForumThread() {
    }
    
    public ForumThread(String title, Post post, ForumUser user){
        this.title = title;
        posts.add(post);
        this.user = user;
    }
    
    public ForumThread(Long id, String title, Post post){
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

    public Date getDate() {
        return date;
    }

    public List<Post> getList() {
        return posts;
    }
}
