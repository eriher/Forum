/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.chl.forum.auth;

import javax.enterprise.context.RequestScoped;

/**
 *
 * @author Simon
 */
@RequestScoped
public class Register {
    private ForumUser user = new ForumUser();

    public ForumUser getUser() {
        return user;
    }

    public void setUser(ForumUser user) {
        this.user = user;
    }
    
    public String add() {
        return "";
    }
}
