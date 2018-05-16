/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.appconsultas.model;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author bfranco
 */
@Entity
@Table(name = "referencia")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Referencia.findAll", query = "SELECT r FROM Referencia r")
    , @NamedQuery(name = "Referencia.findByIdReferencia", query = "SELECT r FROM Referencia r WHERE r.idReferencia = :idReferencia")
    , @NamedQuery(name = "Referencia.findByMotivoRefenrencia", query = "SELECT r FROM Referencia r WHERE r.motivoRefenrencia = :motivoRefenrencia")})
public class Referencia implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_referencia")
    private Integer idReferencia;
    @Size(max = 45)
    @Column(name = "motivo_refenrencia")
    private String motivoRefenrencia;
    @JoinColumn(name = "id_episodio", referencedColumnName = "id_episodio")
    @ManyToOne(optional = false)
    private Episodio idEpisodio;
    @JoinColumn(name = "id_especialista", referencedColumnName = "id_especialista")
    @ManyToOne(optional = false)
    private Especialista idEspecialista;

    public Referencia() {
    }

    public Referencia(Integer idReferencia) {
        this.idReferencia = idReferencia;
    }

    public Integer getIdReferencia() {
        return idReferencia;
    }

    public void setIdReferencia(Integer idReferencia) {
        this.idReferencia = idReferencia;
    }

    public String getMotivoRefenrencia() {
        return motivoRefenrencia;
    }

    public void setMotivoRefenrencia(String motivoRefenrencia) {
        this.motivoRefenrencia = motivoRefenrencia;
    }

    public Episodio getIdEpisodio() {
        return idEpisodio;
    }

    public void setIdEpisodio(Episodio idEpisodio) {
        this.idEpisodio = idEpisodio;
    }

    public Especialista getIdEspecialista() {
        return idEspecialista;
    }

    public void setIdEspecialista(Especialista idEspecialista) {
        this.idEspecialista = idEspecialista;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idReferencia != null ? idReferencia.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Referencia)) {
            return false;
        }
        Referencia other = (Referencia) object;
        if ((this.idReferencia == null && other.idReferencia != null) || (this.idReferencia != null && !this.idReferencia.equals(other.idReferencia))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.appconsultas.model.Referencia[ idReferencia=" + idReferencia + " ]";
    }
    
}
