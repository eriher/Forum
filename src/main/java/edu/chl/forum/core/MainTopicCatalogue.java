/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package edu.chl.forum.core;

import edu.chl.forum.persistence.AbstractDAO;
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
public class MainTopicCatalogue extends AbstractDAO<MainTopic, Long>
        implements IMainTopicCatalogue{
    
        
    @PersistenceContext
    EntityManager em;
    
    public MainTopicCatalogue(){
        super(MainTopic.class);
    }        
    
    
    @Override
    public List<MainTopic> getByName(String name) {
        List<MainTopic> found = new ArrayList<>();
        for (MainTopic p : findRange(0, count())) {
            if (p.getTitle().equals(name)) {
                found.add(p);
            }
        }
        return found;
    }

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }
}
