/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.appconsultas.EJB;

import com.appconsultas.model.Soap;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author bfranco
 */
@Local
public interface SoapFacadeLocal {

    void create(Soap soap);

    void edit(Soap soap);

    void remove(Soap soap);

    Soap find(Object id);

    List<Soap> findAll();

    List<Soap> findRange(int[] range);

    int count();
    
}
