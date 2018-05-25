/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.appconsultas.controller;

import com.appconsultas.EJB.EpisodioFacadeLocal;
import com.appconsultas.model.Episodio;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

/**
 *
 * @author bsf_o
 */
@ViewScoped
@Named
public class EpisodioController implements Serializable{
    private Episodio episodio;
    private List<Episodio> lstEpisodios;
    @EJB
    private EpisodioFacadeLocal episodioEJB;
    
    @PostConstruct
    public void init(){
    episodio= new Episodio();
    lstEpisodios= episodioEJB.findAll();
    }
    
    public void registrarEpisodio(){
    
    }

    public Episodio getEpisodio() {
        return episodio;
    }

    public void setEpisodio(Episodio episodio) {
        this.episodio = episodio;
    }

    public List<Episodio> getLstEpisodios() {
        return lstEpisodios;
    }

    public void setLstEpisodios(List<Episodio> lstEpisodios) {
        this.lstEpisodios = lstEpisodios;
    }
    
    
    
}
