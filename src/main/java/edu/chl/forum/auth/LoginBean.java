/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.chl.forum.auth;

import java.io.Serializable;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import edu.chl.forum.core.Forum;
import edu.chl.forum.core.UserCatalogue;
import edu.chl.forum.view.LoginBB;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.servlet.http.HttpSession;

@ManagedBean
@SessionScoped
/**
 *
 * @author Simon
 */
public class LoginBean implements Serializable{
    private Forum forum;
    @Inject private LoginBB loginBB;
    
    public LoginBean(){
    }

    /**
     * @param forum the forum to set
     */
    @Inject
    public LoginBean(Forum forum) {
        this.forum = forum;
    }

    /**
     * @param loginBB the loginBB to set
     */
    /*
    @Inject
    public void setLoginBB(LoginBB loginBB) {
        this.loginBB = loginBB;
    }*/
    
    public Long getUserId(){
        HttpSession session = (HttpSession)FacesContext.getCurrentInstance().getExternalContext().getSession(false);
        return Long.parseLong(session.getAttribute("id").toString());
    }
    
    public String login(){
        ForumUser user = forum.getUserCatalogue().login(loginBB.getUsername(), loginBB.getPassword());
        if(user != null){
            HttpSession session = (HttpSession)FacesContext.getCurrentInstance().getExternalContext().getSession(false);
            session.setAttribute("id", user.getId());
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
        HttpSession session = (HttpSession)FacesContext.getCurrentInstance().getExternalContext().getSession(false);
        session.invalidate();
        return "login";
    }
}
