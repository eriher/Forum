/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package edu.chl.forum.core;

import edu.chl.forum.util.IEntityContainer;
import java.util.List;

/**
 *
 * @author Olof
 */
public interface IMainTopicCatalogue extends IEntityContainer<MainTopic,Long> {
    
    public List<MainTopic> getByName(String name);
}
