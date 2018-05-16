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
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author bfranco
 */
@Entity
@Table(name = "item")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Item.findAll", query = "SELECT i FROM Item i")
    , @NamedQuery(name = "Item.findByIditemMenu", query = "SELECT i FROM Item i WHERE i.iditemMenu = :iditemMenu")
    , @NamedQuery(name = "Item.findByNombre", query = "SELECT i FROM Item i WHERE i.nombre = :nombre")
    , @NamedQuery(name = "Item.findByUrl", query = "SELECT i FROM Item i WHERE i.url = :url")
    , @NamedQuery(name = "Item.findByEstado", query = "SELECT i FROM Item i WHERE i.estado = :estado")})
public class Item implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_itemMenu")
    private Integer iditemMenu;
    @Size(max = 45)
    @Column(name = "nombre")
    private String nombre;
    @Size(max = 255)
    @Column(name = "url")
    private String url;
    @Column(name = "estado")
    private Short estado;
    @JoinColumn(name = "id_subMenu", referencedColumnName = "id_subMenu")
    @ManyToOne(optional = false)
    private Submenu idsubMenu;
    @JoinColumn(name = "id_tipo_usuario", referencedColumnName = "id_tipo_usuario")
    @ManyToOne(optional = false)
    private TipoUsuario idTipoUsuario;

    public Item() {
    }

    public Item(Integer iditemMenu) {
        this.iditemMenu = iditemMenu;
    }

    public Integer getIditemMenu() {
        return iditemMenu;
    }

    public void setIditemMenu(Integer iditemMenu) {
        this.iditemMenu = iditemMenu;
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

    public Short getEstado() {
        return estado;
    }

    public void setEstado(Short estado) {
        this.estado = estado;
    }

    public Submenu getIdsubMenu() {
        return idsubMenu;
    }

    public void setIdsubMenu(Submenu idsubMenu) {
        this.idsubMenu = idsubMenu;
    }

    public TipoUsuario getIdTipoUsuario() {
        return idTipoUsuario;
    }

    public void setIdTipoUsuario(TipoUsuario idTipoUsuario) {
        this.idTipoUsuario = idTipoUsuario;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (iditemMenu != null ? iditemMenu.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Item)) {
            return false;
        }
        Item other = (Item) object;
        if ((this.iditemMenu == null && other.iditemMenu != null) || (this.iditemMenu != null && !this.iditemMenu.equals(other.iditemMenu))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.appconsultas.model.Item[ iditemMenu=" + iditemMenu + " ]";
    }
    
}
