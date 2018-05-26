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
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author bsf_o
 */
@Entity
@Table(name = "soap")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Soap.findAll", query = "SELECT s FROM Soap s")
    , @NamedQuery(name = "Soap.findByIdSOAP", query = "SELECT s FROM Soap s WHERE s.idSOAP = :idSOAP")
    , @NamedQuery(name = "Soap.findByAnalisis", query = "SELECT s FROM Soap s WHERE s.analisis = :analisis")
    , @NamedQuery(name = "Soap.findByObjetivo", query = "SELECT s FROM Soap s WHERE s.objetivo = :objetivo")
    , @NamedQuery(name = "Soap.findByPlan", query = "SELECT s FROM Soap s WHERE s.plan = :plan")
    , @NamedQuery(name = "Soap.findBySubjetivo", query = "SELECT s FROM Soap s WHERE s.subjetivo = :subjetivo")})
public class Soap implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_SOAP")
    private Integer idSOAP;
    @Size(max = 255)
    @Column(name = "analisis")
    private String analisis;
    @Size(max = 255)
    @Column(name = "objetivo")
    private String objetivo;
    @Size(max = 255)
    @Column(name = "plan")
    private String plan;
    @Size(max = 255)
    @Column(name = "subjetivo")
    private String subjetivo;

    public Soap() {
    }

    public Soap(Integer idSOAP) {
        this.idSOAP = idSOAP;
    }

    public Integer getIdSOAP() {
        return idSOAP;
    }

    public void setIdSOAP(Integer idSOAP) {
        this.idSOAP = idSOAP;
    }

    public String getAnalisis() {
        return analisis;
    }

    public void setAnalisis(String analisis) {
        this.analisis = analisis;
    }

    public String getObjetivo() {
        return objetivo;
    }

    public void setObjetivo(String objetivo) {
        this.objetivo = objetivo;
    }

    public String getPlan() {
        return plan;
    }

    public void setPlan(String plan) {
        this.plan = plan;
    }

    public String getSubjetivo() {
        return subjetivo;
    }

    public void setSubjetivo(String subjetivo) {
        this.subjetivo = subjetivo;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idSOAP != null ? idSOAP.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Soap)) {
            return false;
        }
        Soap other = (Soap) object;
        if ((this.idSOAP == null && other.idSOAP != null) || (this.idSOAP != null && !this.idSOAP.equals(other.idSOAP))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.appconsultas.model.Soap[ idSOAP=" + idSOAP + " ]";
    }
    
}
