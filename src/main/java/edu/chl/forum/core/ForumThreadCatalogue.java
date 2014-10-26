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
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Olof
 */
@Stateless
public class ForumThreadCatalogue extends AbstractDAO<ForumThread, Long>
        implements IForumThreadCatalogue {
    
    @PersistenceContext
    EntityManager em;
    
    
    public ForumThreadCatalogue() {
        super(ForumThread.class);
    }
    
    @Override
    protected EntityManager getEntityManager() {
        return em;
    }
        
    
    
    @Override
    public List<ForumThread> getByName(String name) {
        List<ForumThread> found = new ArrayList<>();
        for (ForumThread p : findRange(0, count())) {
            if (p.getTitle().equals(name)) {
                found.add(p);
            }
        }
        return found;
    }
    
}
