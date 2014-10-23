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
    
    /*
   ¨*   Method for logging in users with clientside input
    */
    public void login(){
        RequestContext context = RequestContext.getCurrentInstance();
        FacesMessage msg;
        this.user = null;
        for(ForumUser u : forum.getUserCatalogue().findAll()){
            if(u.getName().equals(loginBB.getName()) && u.getPassword().equals(loginBB.getPassword())){
                this.user = u;
                break;
            }
        }
        
        if(user != null){
            System.out.println("Login successfull2.");
            msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Welcome", loginBB.getName());
            loggedIn = true;
        } else {
            System.out.println("Login failed2.");
            msg =  new FacesMessage(FacesMessage.SEVERITY_WARN, "Loggin Error", "Invalid credentials");
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
        this.user = null;
        for(ForumUser u : forum.getUserCatalogue().findAll()){
            if(u.getName().equals(name) && u.getPassword().equals(password)){
                this.user = u;
                break;
            }
        }
        
        if(user != null){
            System.out.println("Login successfull2.");
            msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Welcome", name);
            loggedIn = true;
        } else {
            System.out.println("Login failed2.");
            msg =  new FacesMessage(FacesMessage.SEVERITY_WARN, "Loggin Error", "Invalid credentials");
            loggedIn = false;
        }
           
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }
    
    public void logout(){
        this.user = null;
        loggedIn = false;
    }
}
