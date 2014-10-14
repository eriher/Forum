/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package edu.chl.forum.util;

import java.util.List;

/**
 *
 * @author Olof
 * @param <T>
 * @param <K>
 */
public interface IDAO<T , K> {
    
    public void create(T t);

    public void delete(K id);

    public void update(T t);

    public T find(K id);

    public List<T> findAll();

    public List<T> findRange(int first, int n );

    public int count();
}
