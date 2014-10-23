/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.chl.forum.auth;

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
    @EJB
    private IUserCatalogue userCatalogue;
    
    //@Inject //Does not work for some reason!
    public void setRegisterBB(RegisterBB newUser){
        this.registerBB = newUser;
    }
    
    public void add(){
        ForumUser user = new ForumUser(registerBB.getName());
        userCatalogue.create(user);
    }
}
