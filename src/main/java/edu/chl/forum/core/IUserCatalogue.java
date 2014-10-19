/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.chl.forum.core;

import edu.chl.forum.auth.User;
import edu.chl.forum.util.IDAO;
import java.util.List;

/**
 *
 * @author Olof
 */
public interface IUserCatalogue extends IDAO<User,Long> {
    
        public List<User> getByName(String name);
        public User login(String name, String password);
}
