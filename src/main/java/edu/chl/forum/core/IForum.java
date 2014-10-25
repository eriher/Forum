/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package edu.chl.forum.core;

/**
 *
 * @author Olof
 */
public interface IForum {
    
    public IForumThreadCatalogue getThreadCatalogue();
    public ISubTopicCatalogue getSubTopicCatalogue();
    public IMainTopicCatalogue getMainTopicCatalogue();
    public IPostCatalogue getPostCatalogue();
    public IUserCatalogue getUserCatalogue();
}
