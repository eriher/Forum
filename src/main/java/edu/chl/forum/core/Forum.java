/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package edu.chl.forum.core;

import java.io.Serializable;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.enterprise.context.ApplicationScoped;

/**
 *
 * @author Olof
 */
@ApplicationScoped
public class Forum implements IForum, Serializable{
    private static final Logger LOG = Logger.getLogger(Forum.class.getName()); 
    @EJB IForumThreadCatalogue threadCatalogue;
    @EJB ISubTopicCatalogue subTopicCatalogue;
    @EJB IMainTopicCatalogue mainTopicCatalogue;
    @EJB IPostCatalogue postCatalogue;
    @EJB IUserCatalogue userCatalogue; 
    
    
    public Forum() {
        Logger.getAnonymousLogger().log(Level.INFO, "Forum alive");
    }

    @Override
    public IUserCatalogue getUserCatalogue(){
        return userCatalogue;
    }
    
    @Override
    public IForumThreadCatalogue getThreadCatalogue() {
        return threadCatalogue;
    }
    
    @Override
    public ISubTopicCatalogue getSubTopicCatalogue() {
        return subTopicCatalogue;
    }
    
    @Override
    public IMainTopicCatalogue getMainTopicCatalogue() {
        return mainTopicCatalogue;
    }

    @Override
    public IPostCatalogue getPostCatalogue() {
        return postCatalogue;
    }
  
}
