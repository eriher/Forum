/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package edu.chl.forum.util;

import java.io.Serializable;

/**
 *
 * @author Olof
 */
public interface IEntity<K> extends Serializable {
    public K getId();
    
}