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
    
    @EJB IThreadCatalogue threadCatalogue;
    @EJB ISubTopicCatalogue subTopicCatalogue;
    @EJB IMainTopicCatalogue mainTopicCatalogue;
    @EJB IPostCatalogue postCatalogue;
    @EJB IUserCatalogue userCatalogue; 
    
    
    private Forum() {
        Logger.getAnonymousLogger().log(Level.INFO, "Forum alive!");
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
    /*
    public static IForum newInstance(){
       // return new Forum();
    }*/
    
    private void initTestData(){
        Long i = 2212L;
        //threadCatalogue.create(new Thread("test", new Post(i, "olof", "blablabla")));
    } 
}
