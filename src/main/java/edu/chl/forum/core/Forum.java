/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package edu.chl.forum.core;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Olof
 */
public class Forum implements IForum{
    
    private final IThreadCatalogue threadCatalogue = ThreadCatalogue.newInstance();
    
    private Forum() {
        Logger.getAnonymousLogger().log(Level.INFO, "Forum alive!");
    }
    
    
    @Override
    public IThreadCatalogue getThreadCatalogue() {
        return threadCatalogue;
    }
    
    public static IForum newInstance(){
        return new Forum();
    }
    
    private void initTestData(){
        Long i = 2212L;
        threadCatalogue.create(new Thread("test", new Post(i, "olof", "blablabla")));
    }
}
