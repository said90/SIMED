/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.appconsultas.EJB;

import com.appconsultas.model.Diagnostico;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author bsf_o
 */
@Local
public interface DiagnosticoFacadeLocal {

    void create(Diagnostico diagnostico);

    void edit(Diagnostico diagnostico);

    void remove(Diagnostico diagnostico);

    Diagnostico find(Object id);

    List<Diagnostico> findAll();

    List<Diagnostico> findRange(int[] range);

    int count();
    
}
