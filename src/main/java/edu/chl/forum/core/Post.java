/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package edu.chl.forum.core;

import edu.chl.forum.persistence.AbstractEntity;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Transient;

/**
 *
 * @author Olof
 */
@Entity
public class Post extends AbstractEntity  {

    private boolean adminEdit;
    private boolean userEdit;
    private String content;
    private String editText;
    @ManyToOne
    private ForumUser forumUser;
    @Transient
    private final DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm");
    @Transient
    private final Date today = new Date();
    private final String date = df.format(today);

    public Post() {
    }
    
    public Post(String content, ForumUser user){
        this.content = content;
        this.forumUser = user;
    }
    
    public Post(Long id, String content, ForumUser user){
        super(id);
        this.content = content;
        this.forumUser = user;
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
        return forumUser;
    }

    public String getDate() {
        return date;
    }
    
    public String getEditText(){
        return editText;
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
    
    public void setEditText(String editText){
        this.editText = editText;
    }
    
}
