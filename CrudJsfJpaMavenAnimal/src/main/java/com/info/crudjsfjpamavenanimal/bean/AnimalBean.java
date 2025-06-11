/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.info.crudjsfjpamavenanimal.bean;

import com.info.crudjsfjpamavenanimal.dao.AnimalDAO;
import com.info.crudjsfjpamavenanimal.model.Animal;
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
public class AnimalBean implements Serializable {
    @EJB
    private AnimalDAO animalDAO;
    private DataModel<Animal> listaAnimal;
    private String parcial = "";
    private Animal animal = new Animal();

    public String novo() {
        setAnimal(new Animal());
        return "animal";
    }

    public String edita() {
        setAnimal(getListaAnimal().getRowData());
        return "animal";
    }

    public void exclui() {
        setAnimal(getListaAnimal().getRowData());
        animalDAO.excluir(getAnimal());
        atualizaDataModel();
    }

    public String salva() {
        animalDAO.salvar(animal);
        return "index";
    }

    public String cancela() {
        return "index";
    }

    public void atualizaDataModel() {
        setListaAnimal(new ListDataModel<>(animalDAO.pesquisa(getParcial())));
    }

    public DataModel<Animal> getListaAnimal() {
        atualizaDataModel();
        return listaAnimal;
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
     * @return the animal
     */
    public Animal getAnimal() {
        return animal;
    }

    /**
     * @param animal the animal to set
     */
    public void setAnimal(Animal animal) {
        this.animal = animal;
    }

 

    /**
     * @param listaAnimal the listaAnimal to set
     */
    public void setListaAnimal(DataModel<Animal> listaAnimal) {
        this.listaAnimal = listaAnimal;
    }
}
