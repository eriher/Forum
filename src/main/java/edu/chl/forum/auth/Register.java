/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.chl.forum.auth;

import edu.chl.forum.core.ForumUser;
import edu.chl.forum.core.IForum;
import edu.chl.forum.view.RegisterBB;
import java.io.Serializable;
import java.util.List;
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
    private LoginBean loginBean;
    @Inject IForum forum;
    
    @Inject
    public void setreg(RegisterBB registerBB){
        this.registerBB = registerBB;
    }
    
    @Inject
    public void setlog(LoginBean loginBean){
        this.loginBean = loginBean;
    }
    
    public void save(){
        ForumUser user = new ForumUser(registerBB.getName(), registerBB.getPassword(), registerBB.getEmail());
        List<ForumUser> fu = forum.getUserCatalogue().getByName(user.getName());
        List<ForumUser> fu2 = forum.getUserCatalogue().getByEmail(user.getEmail());
        if(fu.size() < 1 && fu2.size() < 1){
            forum.getUserCatalogue().create(user);
            loginBean.login(user.getName(), user.getPassword());
        }
    }
}
