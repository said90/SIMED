/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.appconsultas.EJB;

import com.appconsultas.model.Tipopersona;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author bsf_o
 */
@Local
public interface TipopersonaFacadeLocal {

    void create(Tipopersona tipopersona);

    void edit(Tipopersona tipopersona);

    void remove(Tipopersona tipopersona);

    Tipopersona find(Object id);

    List<Tipopersona> findAll();

    List<Tipopersona> findRange(int[] range);

    int count();
    
}
