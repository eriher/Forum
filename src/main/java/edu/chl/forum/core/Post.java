/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package edu.chl.forum.core;

import edu.chl.forum.auth.User;
import edu.chl.forum.util.AbstractEntity;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author Olof
 */
@Entity
public class Post extends AbstractEntity  {


    private Long threadId;
    private String content;
    @ManyToOne
    private User user;
    @Temporal (TemporalType.DATE)
    private Date date;

    public Post() {
    }
    
    public Post(Long threadId, String content, User user, Date date){
        this.threadId = threadId;
        this.content = content;
        this.user = user;
        this.date = date;
    }
    
    public Post(Long id, Long threadId, String content, User user, Date date){
        super(id);
        this.threadId = threadId;
        this.content = content;
        this.user = user;
        this.date = date;
    }

    public Long getThreadId() {
        return threadId;
    }

    public String getContent() {
        return content;
    }

    public User getUser() {
        return user;
    }

    public Date getDate() {
        return date;
    }
    
    
    
}
