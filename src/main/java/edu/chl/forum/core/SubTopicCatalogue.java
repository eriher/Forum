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
public class SubTopicCatalogue extends AbstractEntityContainer<SubTopic, Long>
        implements ISubTopicCatalogue {
 
    
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
