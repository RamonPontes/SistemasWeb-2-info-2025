/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.info.crudjsfjpamavenproduto.bean;

import com.info.crudjsfjpamavenproduto.dao.ProdutoDAO;
import com.info.crudjsfjpamavenproduto.model.Produto;
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
public class ProdutoBean implements Serializable {

    @EJB
    private ProdutoDAO produtoDAO;

    private DataModel<Produto> listaProduto;
    private String parcial = "";
    private Produto produto = new Produto();

    public String novo() {
        produto = new Produto();
        return "produto";
    }

    public String edita() {
        produto = listaProduto.getRowData();
        return "produto";
    }

    public void exclui() {
        produto = listaProduto.getRowData();
        produtoDAO.excluir(produto);
        atualizaDataModel();
    }

    public String salva() {
        produtoDAO.salvar(produto);
        return "index";
    }

    public String cancela() {
        return "index";
    }

    public void atualizaDataModel() {
        listaProduto = new ListDataModel<>(produtoDAO.pesquisa(parcial));
    }

    public DataModel<Produto> getListaProduto() {
        atualizaDataModel();
        return listaProduto;
    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    public String getParcial() {
        return parcial;
    }

    public void setParcial(String parcial) {
        this.parcial = parcial;
    }
}
