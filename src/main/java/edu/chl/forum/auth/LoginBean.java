/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.chl.forum.auth;

import java.io.Serializable;
import javax.faces.bean.SessionScoped;
import edu.chl.forum.core.IUserCatalogue;
import edu.chl.forum.view.LoginBB;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;

@Named
@SessionScoped
/**
 *
 * @author Simon
 */
public class LoginBean implements Serializable{
    @EJB private IUserCatalogue userCatalogue;
    //@Inject 
    private LoginBB loginBB;
    private ForumUser user;
    
    public LoginBean(){
    }
    
    public String login(){
        this.user = null;
        for(ForumUser u : userCatalogue.findAll()){
            if(u.getName().equals(loginBB.getName()) && u.getPassword().equals(loginBB.getPassword())){
                this.user = u;
                break;
            }
        }
        
        if(user != null){
            return "home";
        } else {
            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage(FacesMessage.SEVERITY_WARN,
                    "Invalid Login!",
                    "Please Try Again!"));
            return "home";
        }
    }
    
    public String login(String name, String password){
        this.user = null;
        for(ForumUser u : userCatalogue.findAll()){
            if(u.getName().equals(name) && u.getPassword().equals(password)){
                this.user = u;
                break;
            }
        }
        
        if(user != null){
            return "home";
        } else {
            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage(FacesMessage.SEVERITY_WARN,
                    "Invalid Login!",
                    "Please Try Again!"));
            return "login";
        }
    }
    
    public String logout(){
        this.user = null;
        return "login";
    }
}
