/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package edu.chl.forum.core;

import edu.chl.forum.util.AbstractEntityContainer;

/**
 *
 * @author Olof
 */
public final class ThreadCatalogue extends AbstractEntityContainer<Thread, Long>
        implements IThreadCatalogue {
    
    private ThreadCatalogue() {
        
    }
    
    public static IThreadCatalogue newInstance() {
        return new ThreadCatalogue();
    }
    
}
