/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.info.crudjsfjpamaven.bean;

import com.info.crudjsfjpamaven.dao.LivroDAO;
import com.info.crudjsfjpamaven.model.Livro;
import java.io.Serializable;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;
import javax.inject.Named;

/**
 *
 * @author info2025
 */
@Named
@SessionScoped
public class LivroBean implements Serializable {
    @EJB
    private LivroDAO livroDAO;
    
    private DataModel<Livro> listaLivro;
    private String parcial = "";
    private Livro livro = new Livro();

    public String novo() {
        livro = new Livro();
        return "livro";
    }
    
    public String edita() {
        livro = listaLivro.getRowData();
        return "livro";
    }
    
    public void exclui() {
        livro = listaLivro.getRowData();
        livroDAO.exclui(livro);
        atualizaDataModel();
    }
    
    public String salva() {
        livroDAO.salva(livro);
        return "index";
    }
    
    public String cancela() {
        return "index";
    }
    
    public void atualizaDataModel() {
        listaLivro = new ListDataModel<>(livroDAO.pesquisa(parcial));
    }
    
    public DataModel<Livro> getListaLivro() {
        atualizaDataModel();
        return listaLivro;
    }
    
    /**
     * @return the parcial
     */
    public String getParcial() {
        return parcial;
    }

    /**
     * @param parcial the parcial to set
     */
    public void setParcial(String parcial) {
        this.parcial = parcial;
    }

    /**
     * @return the livro
     */
    public Livro getLivro() {
        return livro;
    }

    /**
     * @param livro the livro to set
     */
    public void setLivro(Livro livro) {
        this.livro = livro;
    }
    
    
    

}
