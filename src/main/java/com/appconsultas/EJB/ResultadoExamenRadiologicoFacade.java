/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.appconsultas.EJB;

import com.appconsultas.model.ResultadoExamenRadiologico;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author bsf_o
 */
@Stateless
public class ResultadoExamenRadiologicoFacade extends AbstractFacade<ResultadoExamenRadiologico> implements ResultadoExamenRadiologicoFacadeLocal {

    @PersistenceContext(unitName = "PUConsulta_medica")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ResultadoExamenRadiologicoFacade() {
        super(ResultadoExamenRadiologico.class);
    }
    
}
