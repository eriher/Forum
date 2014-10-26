/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package edu.chl.forum.core;

import edu.chl.forum.auth.ForumUser;
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

    private String content;
    @ManyToOne
    private ForumUser user;
    @Temporal (TemporalType.DATE)
    private Date date = new Date();

    public Post() {
    }
    
    public Post(String content, ForumUser user){
        this.content = content;
        this.user = user;
    }
    
    public Post(Long id, String content, ForumUser user){
        super(id);
        this.content = content;
        this.user = user;
    }

    public String getContent() {
        return content;
    }

    public ForumUser getUser() {
        return user;
    }

    public Date getDate() {
        return date;
    }
    
    public void setContent(String content){
        this.content = content;
    }
    
}
