/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package edu.chl.forum.core;

import edu.chl.forum.util.AbstractDAO;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Olof
 */
public class SubTopicCatalogue extends AbstractDAO<SubTopic, Long>
        implements ISubTopicCatalogue {
 
    
    @PersistenceContext
    EntityManager em;
    
    public SubTopicCatalogue(){
        super(SubTopic.class);
    }
    
    @Inject
    public void EntityManager(EntityManager em) {
        this.em = em;
    }
    
    @Override 
    protected EntityManager getEntityManager(){
        return em;
    }
            
    
    
    @Override
    public List<SubTopic> getByName(String name) {
        List<SubTopic> found = new ArrayList<>();
        for (SubTopic p : findRange(0, count())) {
            if (p.getName().equals(name)) {
                found.add(p);
            }
        }
        return found;
    }
}
