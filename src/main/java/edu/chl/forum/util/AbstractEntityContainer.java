/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package edu.chl.forum.util;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Olof
 * @param <T>
 * @param <K>
 */

public abstract class AbstractEntityContainer<T extends IEntity<K>, K>
        implements IEntityContainer<T, K> {

    // Emulate a database
    private final List<T> elems = new ArrayList<>();
  
    @Override
    public void create(T t) {
        if (t == null) {
            throw new IllegalArgumentException("Nulls not allowed");
        }
        elems.add(t);
    }

    @Override
    public void delete(K id) {
        T t = find(id);
        if (t != null) {
            elems.remove(t);
        }
    }

    @Override
    public void update(T t) {
        T old = find(t.getId());
        if (old != null) {
            elems.remove(old);
        }
        elems.add(t);
    }

    @Override
    public T find(K id) {
        for (T t : elems) {
            if (t.getId().equals(id)) { // NOTE: equals, not ==
                return t;
            }
        }
        return null;
    }

    @Override
    public List<T> findAll() {
        return elems;
    }

    @Override
    public List<T> findRange(int first, int n) {
        // From inclusive, to exclusive, no checks here
        if (first + n < elems.size()) {
            return elems.subList(first, first + n);
        } else {
            return elems.subList(first, elems.size());
        }
       
    }

    @Override
    public int count() {
        return elems.size();
    }
}