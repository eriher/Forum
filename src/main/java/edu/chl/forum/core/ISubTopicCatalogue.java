/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package edu.chl.forum.core;

import edu.chl.forum.util.IDAO;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Olof
 */
@Local
public interface ISubTopicCatalogue extends IDAO<SubTopic,Long> {
    
    public List<SubTopic> getByName(String name);
}
