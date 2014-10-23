/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.chl.forum.auth;

import edu.chl.forum.core.IForum;
import edu.chl.forum.core.IUserCatalogue;
import edu.chl.forum.view.RegisterBB;
import java.io.Serializable;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

/**
 *
 * @author Simon
 */
@Named
@RequestScoped
public class Register implements Serializable{
    private RegisterBB registerBB;
    @Inject IForum forum;
    LoginBean loginBean;
    
    @Inject
    public void setreg(RegisterBB registerBB){
        this.registerBB = registerBB;
    }
    
    public void save(){
        System.out.println("Adding new user: " + registerBB.getName() + ", " + registerBB.getPassword() + ", " + registerBB.getEmail());
        ForumUser user = new ForumUser(registerBB.getName(), registerBB.getPassword(), registerBB.getEmail());
        forum.getUserCatalogue().create(user);
        loginBean.login(registerBB.getName(), registerBB.getPassword());
    }
}
