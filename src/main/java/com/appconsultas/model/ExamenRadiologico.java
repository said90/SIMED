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
@Table(name = "examen_radiologico")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ExamenRadiologico.findAll", query = "SELECT e FROM ExamenRadiologico e")
    , @NamedQuery(name = "ExamenRadiologico.findByIdExamenRadiologico", query = "SELECT e FROM ExamenRadiologico e WHERE e.idExamenRadiologico = :idExamenRadiologico")
    , @NamedQuery(name = "ExamenRadiologico.findByDescripcion", query = "SELECT e FROM ExamenRadiologico e WHERE e.descripcion = :descripcion")})
public class ExamenRadiologico implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_examen_radiologico")
    private Integer idExamenRadiologico;
    @Size(max = 100)
    @Column(name = "descripcion")
    private String descripcion;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idExamenRadiologico")
    private List<ExamenRadiologicoIndicado> examenRadiologicoIndicadoList;

    public ExamenRadiologico() {
    }

    public ExamenRadiologico(Integer idExamenRadiologico) {
        this.idExamenRadiologico = idExamenRadiologico;
    }

    public Integer getIdExamenRadiologico() {
        return idExamenRadiologico;
    }

    public void setIdExamenRadiologico(Integer idExamenRadiologico) {
        this.idExamenRadiologico = idExamenRadiologico;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    @XmlTransient
    public List<ExamenRadiologicoIndicado> getExamenRadiologicoIndicadoList() {
        return examenRadiologicoIndicadoList;
    }

    public void setExamenRadiologicoIndicadoList(List<ExamenRadiologicoIndicado> examenRadiologicoIndicadoList) {
        this.examenRadiologicoIndicadoList = examenRadiologicoIndicadoList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idExamenRadiologico != null ? idExamenRadiologico.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ExamenRadiologico)) {
            return false;
        }
        ExamenRadiologico other = (ExamenRadiologico) object;
        if ((this.idExamenRadiologico == null && other.idExamenRadiologico != null) || (this.idExamenRadiologico != null && !this.idExamenRadiologico.equals(other.idExamenRadiologico))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.appconsultas.model.ExamenRadiologico[ idExamenRadiologico=" + idExamenRadiologico + " ]";
    }
    
}
