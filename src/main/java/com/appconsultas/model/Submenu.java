/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.appconsultas.model;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author bsf_o
 */
@Entity
@Table(name = "submenu")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Submenu.findAll", query = "SELECT s FROM Submenu s")
    , @NamedQuery(name = "Submenu.findByIdsubMenu", query = "SELECT s FROM Submenu s WHERE s.idsubMenu = :idsubMenu")
    , @NamedQuery(name = "Submenu.findByEstado", query = "SELECT s FROM Submenu s WHERE s.estado = :estado")
    , @NamedQuery(name = "Submenu.findByNombre", query = "SELECT s FROM Submenu s WHERE s.nombre = :nombre")
    , @NamedQuery(name = "Submenu.findByUrl", query = "SELECT s FROM Submenu s WHERE s.url = :url")})
public class Submenu implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_subMenu")
    private Integer idsubMenu;
    @Column(name = "estado")
    private Short estado;
    @Size(max = 255)
    @Column(name = "nombre")
    private String nombre;
    @Size(max = 255)
    @Column(name = "url")
    private String url;
    @OneToMany(mappedBy = "idsubMenu")
    private List<Item> itemList;

    public Submenu() {
    }

    public Submenu(Integer idsubMenu) {
        this.idsubMenu = idsubMenu;
    }

    public Integer getIdsubMenu() {
        return idsubMenu;
    }

    public void setIdsubMenu(Integer idsubMenu) {
        this.idsubMenu = idsubMenu;
    }

    public Short getEstado() {
        return estado;
    }

    public void setEstado(Short estado) {
        this.estado = estado;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @XmlTransient
    public List<Item> getItemList() {
        return itemList;
    }

    public void setItemList(List<Item> itemList) {
        this.itemList = itemList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idsubMenu != null ? idsubMenu.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Submenu)) {
            return false;
        }
        Submenu other = (Submenu) object;
        if ((this.idsubMenu == null && other.idsubMenu != null) || (this.idsubMenu != null && !this.idsubMenu.equals(other.idsubMenu))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.appconsultas.model.Submenu[ idsubMenu=" + idsubMenu + " ]";
    }
    
}
