/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.appconsultas.EJB;

import com.appconsultas.model.Soap;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author bfranco
 */
@Stateless
public class SoapFacade extends AbstractFacade<Soap> implements SoapFacadeLocal {

    @PersistenceContext(unitName = "PUConsulta_medica")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public SoapFacade() {
        super(Soap.class);
    }
    
}
