/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package edu.chl.forum.core;

import edu.chl.forum.util.AbstractDAO;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Olof
 */
@Stateless
public  class ThreadCatalogue extends AbstractDAO<Thread, Long>
        implements IThreadCatalogue {
    
    @PersistenceContext
    EntityManager em;
    

    public static IThreadCatalogue newInstance() {
        return new ThreadCatalogue();
    }
    
    public ThreadCatalogue() {
        super(Thread.class);
    }
    
    @PersistenceContext
    public void EntityManager(EntityManager em) {
        this.em = em;
    }
    
    @Override
    protected EntityManager getEntityManager() {
        return em;
    }
        
    
    
    @Override
    public List<Thread> getByName(String name) {
        List<Thread> found = new ArrayList<>();
        for (Thread p : findRange(0, count())) {
            if (p.getTitle().equals(name)) {
                found.add(p);
            }
        }
        return found;
    }
    
}
