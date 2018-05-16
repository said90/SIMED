/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.appconsultas.EJB;

import com.appconsultas.model.Submenu;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author bfranco
 */
@Local
public interface SubmenuFacadeLocal {

    void create(Submenu submenu);

    void edit(Submenu submenu);

    void remove(Submenu submenu);

    Submenu find(Object id);

    List<Submenu> findAll();

    List<Submenu> findRange(int[] range);

    int count();
    
}
