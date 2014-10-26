/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.chl.forum.core;

import edu.chl.forum.persistence.IDAO;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Olof
 */
@Local
public interface IUserCatalogue extends IDAO<ForumUser,Long> {
    
        public List<ForumUser> getByName(String name);
        public List<ForumUser> getByEmail(String email);
        //public ForumUser loginCheck(String name, String password);
}
