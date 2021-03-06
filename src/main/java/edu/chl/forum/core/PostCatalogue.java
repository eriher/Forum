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
public class PostCatalogue extends AbstractDAO<Post, Long>
        implements IPostCatalogue{
    
    @PersistenceContext
    EntityManager em;
    
    public PostCatalogue(){
        super(Post.class);
    }

    @Override 
    protected EntityManager getEntityManager(){
        return em;
    }
    
    @Override
    public List<Post> getPostsByUserId(long id){
        List<Post> found = new ArrayList();
        for (Post p : findRange(0, count())) {
            if(p.getForumUser().getId().equals(id)){
                found.add(p);
            }
        }
        return found;
    }
            
    @Override
    public List<Post> getByName(String name) {
        List<Post> found = new ArrayList<>();
        for (Post p : findRange(0, count())) {
            if (p.getContent().equals(name)) {
                found.add(p);
            }
        }
        return found;
    }
}
