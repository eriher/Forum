/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package edu.chl.forum.core;

import edu.chl.forum.util.AbstractEntityContainer;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Olof
 */
public final class MainTopicCatalogue extends AbstractEntityContainer<MainTopic, Long>
        implements IMainTopicCatalogue{
    
    
    @Override
    public List<MainTopic> getByName(String name) {
        List<MainTopic> found = new ArrayList<>();
        for (MainTopic p : findRange(0, count())) {
            if (p.getName().equals(name)) {
                found.add(p);
            }
        }
        return found;
    }
}
