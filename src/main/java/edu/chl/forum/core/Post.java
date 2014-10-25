/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package edu.chl.forum.core;

import edu.chl.forum.auth.ForumUser;
import edu.chl.forum.util.AbstractEntity;
import java.util.Date;
import javax.persistence.CascadeType;
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

    private boolean adminEdit;
    private boolean userEdit;
    private String content;
    @ManyToOne(cascade=CascadeType.PERSIST)
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
    
    public boolean getAdminEdit(){
        return adminEdit;
    }
    
    public boolean getUserEdit(){
        return userEdit;
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
    
    public void setUserEdit(boolean userEdit){
        this.userEdit = userEdit;
    }
    
    public void setAdminEdit(boolean adminEdit){
        this.adminEdit = adminEdit;
    }
    
}
