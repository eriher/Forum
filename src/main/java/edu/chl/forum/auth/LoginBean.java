/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.chl.forum.auth;

import edu.chl.forum.core.IForum;
import java.io.Serializable;
import javax.enterprise.context.SessionScoped;
import edu.chl.forum.view.LoginBB;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import org.primefaces.context.RequestContext;


/**
 *
 * @author Simon
 */
@Named
@SessionScoped
public class LoginBean implements Serializable{
    @Inject IForum forum;
    @Inject LoginBB loginBB;
    private ForumUser user;
    private boolean loggedIn;

    public LoginBean(){
    }
    
    public boolean isLoggedIn() {
        return loggedIn;
    }
    
    public ForumUser getUser() {
        return this.user;
    }
    
    @PostConstruct
    public void init(){
        this.user = null;
        this.loggedIn = false;
    }
    
    /*
   ¨*   Method for logging in users with clientside input
    */
    public void login(){
        //DEBUG CODE
        System.out.println("logging in user: " + loginBB.getName() + ", "  + loginBB.getPassword());
        System.out.println("Users in db: ");
        for(ForumUser n : forum.getUserCatalogue().findAll()){
            System.out.println("U" + n + ": " + n.getName());
        }
        //DEBUG CODE
        
        RequestContext context = RequestContext.getCurrentInstance();
        FacesMessage msg;
        
        List<ForumUser> us = forum.getUserCatalogue().getByName(loginBB.getName());
        
        if(us.size() > 0){
            ForumUser u = us.get(0);
            if(u.getPassword().equals(loginBB.getPassword())){
                System.out.println("Login successfull.");
                msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Welcome", loginBB.getName());
                this.user = u;
                loggedIn = true;
            } else {
                System.out.println("Login failed.");
                msg = new FacesMessage(FacesMessage.SEVERITY_WARN, "Loggin Error", "Wrong password");
                loggedIn = false;
            }
        } else {
            System.out.println("Login failed.");
            msg =  new FacesMessage(FacesMessage.SEVERITY_WARN, "Loggin Error", "User does not exist");
            loggedIn = false;
        }
        
        FacesContext.getCurrentInstance().addMessage(null, msg);
        context.addCallbackParam("loggedIn", loggedIn);
    }
    
    /*
   ¨*   Method for logging in users without clientside input
    */
    public void login(String name, String password){
        FacesMessage msg;
        List<ForumUser> us = forum.getUserCatalogue().getByName(name);
        
        if(us.size() > 0){
            ForumUser u = us.get(0);
            if(u.getPassword().equals(password)){
                System.out.println("Login successfull.");
                msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Welcome", name);
                this.user = u;
                loggedIn = true;
            } else {
                System.out.println("Login failed.");
                msg = new FacesMessage(FacesMessage.SEVERITY_WARN, "Loggin Error", "Wrong password");
                loggedIn = false;
            }
        } else {
            System.out.println("Login failed.");
            msg =  new FacesMessage(FacesMessage.SEVERITY_WARN, "Loggin Error", "User does not exist");
            loggedIn = false;
        }
        
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }
    
    /*
    *   Method for logging out users
    */
    public void logout(){
        FacesMessage msg;
        msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Logged out", user.getName());
        FacesContext.getCurrentInstance().addMessage(null, msg);
        this.user = null;
        loggedIn = false;
    }
}
