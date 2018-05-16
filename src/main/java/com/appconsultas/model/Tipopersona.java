/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.appconsultas.model;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author bfranco
 */
@Entity
@Table(name = "tipopersona")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Tipopersona.findAll", query = "SELECT t FROM Tipopersona t")
    , @NamedQuery(name = "Tipopersona.findByIdTipoPersona", query = "SELECT t FROM Tipopersona t WHERE t.idTipoPersona = :idTipoPersona")
    , @NamedQuery(name = "Tipopersona.findByTipoPersona", query = "SELECT t FROM Tipopersona t WHERE t.tipoPersona = :tipoPersona")})
public class Tipopersona implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "idTipoPersona")
    private Integer idTipoPersona;
    @Size(max = 45)
    @Column(name = "TipoPersona")
    private String tipoPersona;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idTipoPersona")
    private List<Persona> personaList;

    public Tipopersona() {
    }

    public Tipopersona(Integer idTipoPersona) {
        this.idTipoPersona = idTipoPersona;
    }

    public Integer getIdTipoPersona() {
        return idTipoPersona;
    }

    public void setIdTipoPersona(Integer idTipoPersona) {
        this.idTipoPersona = idTipoPersona;
    }

    public String getTipoPersona() {
        return tipoPersona;
    }

    public void setTipoPersona(String tipoPersona) {
        this.tipoPersona = tipoPersona;
    }

    @XmlTransient
    public List<Persona> getPersonaList() {
        return personaList;
    }

    public void setPersonaList(List<Persona> personaList) {
        this.personaList = personaList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idTipoPersona != null ? idTipoPersona.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Tipopersona)) {
            return false;
        }
        Tipopersona other = (Tipopersona) object;
        if ((this.idTipoPersona == null && other.idTipoPersona != null) || (this.idTipoPersona != null && !this.idTipoPersona.equals(other.idTipoPersona))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.appconsultas.model.Tipopersona[ idTipoPersona=" + idTipoPersona + " ]";
    }
    
}
