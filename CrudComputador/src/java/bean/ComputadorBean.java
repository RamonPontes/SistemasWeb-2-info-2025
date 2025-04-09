/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bean;

import bd.BdComputador;
import java.io.Serializable;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;
import vo.Computador;

/**
 *
 * @author info2025
 */
@ManagedBean
@SessionScoped
public class ComputadorBean implements Serializable{
    private Computador computador;
    private final BdComputador bdc = new BdComputador();
    private DataModel<Computador> lista;
    
    public final void atualizaLista() {
        setLista((DataModel<Computador>) new ListDataModel(getBdc().pesquisa("")));
    }
    
    public ComputadorBean() {
        atualizaLista();
    }
    
    public String salva() {
        bdc.salva(getComputador());
        atualizaLista();
        
        return "index";
    }
    
    public String exclui() {
        setComputador(getLista().getRowData());
        bdc.exclui(getComputador().getId());
        atualizaLista();
        
        return "";
    }
    
    public String novo() {
        setComputador(new Computador());
        
        return "computador";
    }
    
    public String edita() {
        setComputador(getLista().getRowData());
        
        return "computador";
    }
    
    /**
     * @return the computador
     */
    public Computador getComputador() {
        return computador;
    }

    /**
     * @param computador the computador to set
     */
    public void setComputador(Computador computador) {
        this.computador = computador;
    }

    /**
     * @return the bdc
     */
    public BdComputador getBdc() {
        return bdc;
    }

    /**
     * @return the lista
     */
    public DataModel<Computador> getLista() {
        return lista;
    }

    /**
     * @param lista the lista to set
     */
    public void setLista(DataModel<Computador> lista) {
        this.lista = lista;
    }
    
    
    
}
