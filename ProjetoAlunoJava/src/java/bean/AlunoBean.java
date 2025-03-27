/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bean;

import bd.BdAluno;
import java.io.Serializable;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;
import vo.Aluno;

/**
 *
 * @author info2025
 */
@ManagedBean
@SessionScoped
public class AlunoBean implements Serializable {
    private Aluno aluno;
    private final BdAluno bda = new BdAluno();
    private DataModel<Aluno> lista;
    
    public AlunoBean() {
        atualizaLista();
    }
    
    public String salva() {
        bda.salva(getAluno());
        atualizaLista();
        
        return "index";
    }
    
    public final void atualizaLista() {
        setLista((DataModel<Aluno>) new ListDataModel(bda.pesquisa("")));
    }
    
    public String exclui() {
        setAluno(getLista().getRowData());
        bda.exclui(getAluno().getCodigo());
        atualizaLista();
        
        return "";
    }
    
    public String novo() {
        setAluno(new Aluno());
        
        return "aluno";
    }
    
    public String edita() {
        setAluno(getLista().getRowData());
        
        return "aluno";
    }

    /**
     * @return the aluno
     */
    public Aluno getAluno() {
        return aluno;
    }

    /**
     * @param aluno the aluno to set
     */
    public void setAluno(Aluno aluno) {
        this.aluno = aluno;
    }

    /**
     * @return the lista
     */
    public DataModel<Aluno> getLista() {
        return lista;
    }

    /**
     * @param lista the lista to set
     */
    public void setLista(DataModel<Aluno> lista) {
        this.lista = lista;
    }
}
