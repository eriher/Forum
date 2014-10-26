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
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

/**
 *
 * @author Olof
 */
@Entity
public class ForumThread extends AbstractEntity{
    
    @ManyToOne(cascade= CascadeType.PERSIST)
    private ForumUser forumUser;
    private String title;
    private boolean locked;
    
    @OneToMany(cascade= CascadeType.ALL, orphanRemoval=true)
    @JoinColumn(name = "FORUMTHREAD_ID")
    private List<Post> posts;

    public ForumThread() {
    }
    
    public ForumThread(String title, Post post, ForumUser user){
        posts = new ArrayList();
        this.title = title;
        posts.add(post);
        this.forumUser = user;
    }
    
    public ForumThread(Long id, String title, Post post, ForumUser user){
        super(id);
        posts = new ArrayList();
        this.title = title;
        posts.add(post);
        this.forumUser = user;
    }
    
    public boolean addPost(Post post) {
        return posts.add(post);
    }
    
    public String getTitle(){
        return title;
    }

    public List<Post> getList() {
        return posts;
    }

    public boolean isLocked() {
        return locked;
    }

    public void setLocked(boolean locked) {
        this.locked = locked;
    }

    public ForumUser getUser() {
        return forumUser;
    }

    public void setTitle(String title) {
        this.title = title;
    }
    
    
}
