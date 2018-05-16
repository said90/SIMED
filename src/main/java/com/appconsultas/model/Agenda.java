/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.appconsultas.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author bfranco
 */
@Entity
@Table(name = "agenda")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Agenda.findAll", query = "SELECT a FROM Agenda a")
    , @NamedQuery(name = "Agenda.findByIdAgenda", query = "SELECT a FROM Agenda a WHERE a.idAgenda = :idAgenda")
    , @NamedQuery(name = "Agenda.findByFechaActual", query = "SELECT a FROM Agenda a WHERE a.fechaActual = :fechaActual")
    , @NamedQuery(name = "Agenda.findByFechaCita", query = "SELECT a FROM Agenda a WHERE a.fechaCita = :fechaCita")
    , @NamedQuery(name = "Agenda.findByEstado", query = "SELECT a FROM Agenda a WHERE a.estado = :estado")})
public class Agenda implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_agenda")
    private Integer idAgenda;
    @Column(name = "fecha_actual")
    @Temporal(TemporalType.DATE)
    private Date fechaActual;
    @Column(name = "fecha_cita")
    @Temporal(TemporalType.DATE)
    private Date fechaCita;
    @Size(max = 45)
    @Column(name = "estado")
    private String estado;
    @JoinColumn(name = "id_persona", referencedColumnName = "id_persona")
    @ManyToOne(optional = false)
    private Persona idPersona;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idAgenda")
    private List<Episodio> episodioList;

    public Agenda() {
    }

    public Agenda(Integer idAgenda) {
        this.idAgenda = idAgenda;
    }

    public Integer getIdAgenda() {
        return idAgenda;
    }

    public void setIdAgenda(Integer idAgenda) {
        this.idAgenda = idAgenda;
    }

    public Date getFechaActual() {
        return fechaActual;
    }

    public void setFechaActual(Date fechaActual) {
        this.fechaActual = fechaActual;
    }

    public Date getFechaCita() {
        return fechaCita;
    }

    public void setFechaCita(Date fechaCita) {
        this.fechaCita = fechaCita;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Persona getIdPersona() {
        return idPersona;
    }

    public void setIdPersona(Persona idPersona) {
        this.idPersona = idPersona;
    }

    @XmlTransient
    public List<Episodio> getEpisodioList() {
        return episodioList;
    }

    public void setEpisodioList(List<Episodio> episodioList) {
        this.episodioList = episodioList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idAgenda != null ? idAgenda.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Agenda)) {
            return false;
        }
        Agenda other = (Agenda) object;
        if ((this.idAgenda == null && other.idAgenda != null) || (this.idAgenda != null && !this.idAgenda.equals(other.idAgenda))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.appconsultas.model.Agenda[ idAgenda=" + idAgenda + " ]";
    }
    
}
