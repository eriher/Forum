/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.chl.forum.core;

import edu.chl.forum.auth.ForumUser;
import edu.chl.forum.util.AbstractDAO;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

/**
 *
 * @author Olof
 */
public class UserCatalogue extends AbstractDAO<ForumUser, Long> 
        implements IUserCatalogue{
    
    @PersistenceContext
    EntityManager em;
    
    public UserCatalogue(){
        super(ForumUser.class);
    }
    
    @PersistenceContext
    public void EntityManager(EntityManager em) {
        this.em = em;
    }
    
    @Override 
    protected EntityManager getEntityManager(){
        return em;
    }
    
    @Override
    public List<ForumUser> getByName(String name) {
        List<ForumUser> found = new ArrayList<>();
        for (ForumUser p : findRange(0, count())) {
            if (p.getName().equals(name)) {
                found.add(p);
            }
        }
        return found;
    }
    
    public ForumUser login(String name, String password){
        EntityManager em = getEntityManager();
        TypedQuery q = em.createQuery("select U from User U where U.name=':name' and U.password=':password'",ForumUser.class);
        q.setParameter("name", name);
        q.setParameter("password", password);
        
        List<ForumUser> found = q.getResultList();
        
        if(found.isEmpty()){
            return null;
        } else {
            return found.get(0);
        }
    }
}
