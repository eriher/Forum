/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package edu.chl.forum.core;

import edu.chl.forum.auth.ForumUser;
import java.io.Serializable;
import java.util.Date;
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
    
    @EJB IThreadCatalogue threadCatalogue;
    @EJB ISubTopicCatalogue subTopicCatalogue;
    @EJB IMainTopicCatalogue mainTopicCatalogue;
    @EJB IPostCatalogue postCatalogue;
    @EJB IUserCatalogue userCatalogue; 
    
    
    private Forum() {
        System.gc();
        Logger.getAnonymousLogger().log(Level.INFO, "Forum alive!");
        //initTestData();
    }
    
    @Override
    public IUserCatalogue getUserCatalogue(){
        return userCatalogue;
    }
    
    @Override
    public IThreadCatalogue getThreadCatalogue() {
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
  
    private void initTestData(){
        Long i = 2212L;
        
        postCatalogue.create(new Post(i,"Text1", new ForumUser("test"), new Date()));
        postCatalogue.create(new Post(22L,"Text2", new ForumUser("test"), new Date()));
        postCatalogue.create(new Post(33L,"Text3", new ForumUser("test"), new Date()));
        postCatalogue.create(new Post(44L,"Text4", new ForumUser("test"), new Date()));

    } 
}
