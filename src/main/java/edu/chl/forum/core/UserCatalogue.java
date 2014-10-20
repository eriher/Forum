/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.chl.forum.core;

import edu.chl.forum.auth.User;
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
public class UserCatalogue extends AbstractDAO<User, Long> 
        implements IUserCatalogue{
    
    @PersistenceContext
    EntityManager em;
    
    public UserCatalogue(){
        super(User.class);
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
    public List<User> getByName(String name) {
        List<User> found = new ArrayList<>();
        for (User p : findRange(0, count())) {
            if (p.getName().equals(name)) {
                found.add(p);
            }
        }
        return found;
    }
    
    public User login(String name, String password){
        EntityManager em = getEntityManager();
        TypedQuery q = em.createQuery("select U from User U where U.name=':name' and U.password=':password'",User.class);
        q.setParameter("name", name);
        q.setParameter("password", password);
        
        List<User> found = q.getResultList();
        
        if(found.isEmpty()){
            return null;
        } else {
            return found.get(0);
        }
    }
}
