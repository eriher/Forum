/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.chl.forum.auth;

import edu.chl.forum.core.ForumUser;
import edu.chl.forum.core.IForum;
import edu.chl.forum.core.Post;
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
    public String login(){
        //DEBUG CODE
        System.out.println("logging in user: " + loginBB.getName() + ", "  + loginBB.getPassword());
        System.out.println("Users in db: ");
        for(ForumUser n : forum.getUserCatalogue().findAll()){
            System.out.println("U" + n + ": " + n.getName());
        }
        //DEBUG CODE
        List<ForumUser> us = forum.getUserCatalogue().getByName(loginBB.getName());
        
        if(us.size() > 0){
            ForumUser u = us.get(0);
            if(u.getPassword().equals(loginBB.getPassword())){
                System.out.println("Login successfull.");
                this.user = u;
                loggedIn = true;
            } else {
                System.out.println("Login failed.");
                loggedIn = false;
            }
        } else {
            System.out.println("Login failed.");
            loggedIn = false;
        }
        return "/index?faces-redirect=true";
    }
    
    /*
   ¨*   Method for logging in users without clientside input
    */
    public String login(String name, String password){
        FacesMessage msg;
        List<ForumUser> us = forum.getUserCatalogue().getByName(name);
        
        if(us.size() > 0){
            ForumUser u = us.get(0);
            if(u.getPassword().equals(password)){
                System.out.println("Login successfull.");
                this.user = u;
                loggedIn = true;
            } else {
                System.out.println("Login failed.");
                loggedIn = false;
            }
        } else {
            System.out.println("Login failed.");
            loggedIn = false;
        }
        return "/index?faces-redirect=true";
    }
    
    /*
    *   Method for logging out users
    */
    public String logout(){
        System.out.println("Logging out user " + user.getName());
        this.user = null;
        loggedIn = false;
        return "/index?faces-redirect=true";
    }
    
    public int countPosts(long id){
        int posts = 0;
        List<Post> ps = forum.getPostCatalogue().findAll();
        for(int n = 0; n < ps.size(); n++) {
            if(ps.get(n).getForumUser().getId().equals(id)){
                posts++;
            }
        }
        return posts;
    }
    
    public String getRank(long id){
        switch(forum.getUserCatalogue().find(id).getRank()){
            case 0:
                return "User";
            case 1:
                return "Moderator";
            default:
                return "Admin";
        }
    }
}