/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.appconsultas.controller;

import com.appconsultas.EJB.AgendaFacadeLocal;
import com.appconsultas.EJB.EpisodioFacadeLocal;
import com.appconsultas.model.Agenda;
import com.appconsultas.model.Diagnostico;
import com.appconsultas.model.Episodio;
import java.io.Serializable;
import java.util.Calendar;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Named;
import org.primefaces.event.SelectEvent;
import org.primefaces.model.DefaultScheduleEvent;
import org.primefaces.model.DefaultScheduleModel;
import org.primefaces.model.ScheduleEvent;
import org.primefaces.model.ScheduleModel;

/**
 *
 * @author bsf_o
 */
@SessionScoped
@Named
public class EpisodioController implements Serializable {

    private Episodio episodio;
    private Agenda cita;
    private List<Episodio> lstEpisodios;
    private List<Agenda> lstCitas;
    private List<Diagnostico> diagnosticosSeleccionado;
    private ScheduleModel eventModel;
    private ScheduleEvent event;
    

    @EJB
    private AgendaFacadeLocal agendaEJB;
    @EJB
    private EpisodioFacadeLocal episodioEJB;

    @PostConstruct
    public void init() {
        episodio = new Episodio();
        lstEpisodios = episodioEJB.findAll();
        lstCitas = agendaEJB.findAll();
        cita = new Agenda();
        eventModel = new DefaultScheduleModel();
        event = new DefaultScheduleEvent();
        llenarSchedule();
    }

    public void registrarEpisodio() {
        episodioEJB.create(episodio);
    }

    public void llenarSchedule() {
        int minutos = 30;
        Calendar calendar = Calendar.getInstance();
        for (Agenda ca : lstCitas) {
            calendar.setTime(ca.getFechaCita());
            calendar.add(Calendar.MINUTE, minutos);
            eventModel.addEvent(new DefaultScheduleEvent("Paciente: " + ca.getIdPaciente().getIdPersona().getNombres() + "  " + ca.getIdPaciente().getIdPersona().getApellidos()
                    + " - " + "Medico Asignado: " + " Dr." + ca.getIdMedico().getIdPersona().getNombres() + ca.getIdMedico().getIdPersona().getApellidos()
                    + " - " + "Motivo de consulta: " + ca.getMotivoConsulta(),
                    ca.getFechaCita(), calendar.getTime(), ca));

        }
    }

    public void onEventSelect(SelectEvent selectEvent) {
        event = (ScheduleEvent) selectEvent.getObject();
        cita = (Agenda) event.getData();
        try {
            FacesContext.getCurrentInstance().getExternalContext().redirect("/SIMED/consultamedica/consultaPaciente.xhtml?faces-redirect=true");

        } catch (Exception e) {
        }

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

    public Agenda getCita() {
        return cita;
    }

    public void setCita(Agenda cita) {
        this.cita = cita;
    }

    public List<Agenda> getLstCitas() {
        return lstCitas;
    }

    public void setLstCitas(List<Agenda> lstCitas) {
        this.lstCitas = lstCitas;
    }

    public ScheduleModel getEventModel() {
        return eventModel;
    }

    public void setEventModel(ScheduleModel eventModel) {
        this.eventModel = eventModel;
    }

    public List<Diagnostico> getDiagnosticosSeleccionado() {
        return diagnosticosSeleccionado;
    }

    public void setDiagnosticosSeleccionado(List<Diagnostico> diagnosticosSeleccionado) {
        this.diagnosticosSeleccionado = diagnosticosSeleccionado;
    }
    
    

}
