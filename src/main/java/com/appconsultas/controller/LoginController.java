/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.appconsultas.controller;

import com.appconsultas.EJB.ItemFacadeLocal;
import com.appconsultas.EJB.SubmenuFacadeLocal;
import com.appconsultas.model.Item;
import com.appconsultas.model.Submenu;
import com.appconsultas.model.Usuario;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import org.primefaces.model.menu.DefaultMenuItem;
import org.primefaces.model.menu.DefaultMenuModel;
import org.primefaces.model.menu.DefaultSubMenu;
import org.primefaces.model.menu.MenuElement;
import org.primefaces.model.menu.MenuModel;

/**
 *
 * @author bsf_o
 */
@Named
@SessionScoped
public class LoginController implements Serializable {

    private Item itemMenu;
    @EJB
    private ItemFacadeLocal itemMenuEJB;
    private MenuModel model;
    List<Item> listaItems;

    @PostConstruct
    public void init() {

        this.listarMenus();
        model = new DefaultMenuModel();

    }

    public void listarMenus() {
        try {
            listaItems = itemMenuEJB.findAll();

        } catch (Exception e) {
        }

    }

    public void establecerPermisos() {

        Usuario us = (Usuario) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("usuario");
        DefaultSubMenu sub;
        List<MenuElement> elementos = model.getElements();

        for (Item s : listaItems) {
            if (s.getIdTipoUsuario().equals(us.getIdTipoUsuario()) && s.getEstado() == 1) {

                DefaultSubMenu submenu = new DefaultSubMenu(s.getIdsubMenu().getNombre());

                DefaultMenuItem item = new DefaultMenuItem(s.getNombre());
                item.setUrl(s.getUrl());
                submenu.addElement(item);

                model.addElement(submenu);

            }
        }
    }

    public void cerrarSesion() {
        FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
    }

    public Item getItemMenu() {
        return itemMenu;
    }

    public void setItemMenu(Item itemMenu) {
        this.itemMenu = itemMenu;
    }

    public MenuModel getModel() {
        return model;
    }

    public void setModel(MenuModel model) {
        this.model = model;
    }

    public List<Item> getListaItems() {
        return listaItems;
    }

    public void setListaItems(List<Item> listaItems) {
        this.listaItems = listaItems;
    }

}
