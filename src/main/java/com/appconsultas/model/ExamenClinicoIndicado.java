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
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.Size;

/**
 *
 * @author bsf_o
 */
@Entity
@Table(name = "examen_clinico_indicado")
@NamedQueries({
    @NamedQuery(name = "ExamenClinicoIndicado.findAll", query = "SELECT e FROM ExamenClinicoIndicado e")
    , @NamedQuery(name = "ExamenClinicoIndicado.findByIdExamenClinicoIndicado", query = "SELECT e FROM ExamenClinicoIndicado e WHERE e.idExamenClinicoIndicado = :idExamenClinicoIndicado")
    , @NamedQuery(name = "ExamenClinicoIndicado.findByExamenClinicoIndicado", query = "SELECT e FROM ExamenClinicoIndicado e WHERE e.examenClinicoIndicado = :examenClinicoIndicado")})
public class ExamenClinicoIndicado implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_examen_clinico_indicado")
    private Integer idExamenClinicoIndicado;
    @Size(max = 45)
    @Column(name = "examen_clinico_indicado")
    private String examenClinicoIndicado;
    @JoinColumn(name = "id_episodio", referencedColumnName = "id_episodio")
    @ManyToOne(optional = false)
    private Episodio idEpisodio;
    @JoinColumn(name = "id_examen_lab_clinico", referencedColumnName = "id_examen_lab_clinico")
    @ManyToOne(optional = false)
    private ExamenLabClinico idExamenLabClinico;

    public ExamenClinicoIndicado() {
    }

    public ExamenClinicoIndicado(Integer idExamenClinicoIndicado) {
        this.idExamenClinicoIndicado = idExamenClinicoIndicado;
    }

    public Integer getIdExamenClinicoIndicado() {
        return idExamenClinicoIndicado;
    }

    public void setIdExamenClinicoIndicado(Integer idExamenClinicoIndicado) {
        this.idExamenClinicoIndicado = idExamenClinicoIndicado;
    }

    public String getExamenClinicoIndicado() {
        return examenClinicoIndicado;
    }

    public void setExamenClinicoIndicado(String examenClinicoIndicado) {
        this.examenClinicoIndicado = examenClinicoIndicado;
    }

    public Episodio getIdEpisodio() {
        return idEpisodio;
    }

    public void setIdEpisodio(Episodio idEpisodio) {
        this.idEpisodio = idEpisodio;
    }

    public ExamenLabClinico getIdExamenLabClinico() {
        return idExamenLabClinico;
    }

    public void setIdExamenLabClinico(ExamenLabClinico idExamenLabClinico) {
        this.idExamenLabClinico = idExamenLabClinico;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idExamenClinicoIndicado != null ? idExamenClinicoIndicado.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ExamenClinicoIndicado)) {
            return false;
        }
        ExamenClinicoIndicado other = (ExamenClinicoIndicado) object;
        if ((this.idExamenClinicoIndicado == null && other.idExamenClinicoIndicado != null) || (this.idExamenClinicoIndicado != null && !this.idExamenClinicoIndicado.equals(other.idExamenClinicoIndicado))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.appconsultas.model.ExamenClinicoIndicado[ idExamenClinicoIndicado=" + idExamenClinicoIndicado + " ]";
    }
    
}
