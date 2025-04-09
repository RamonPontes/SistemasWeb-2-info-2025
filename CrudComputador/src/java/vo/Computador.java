/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package vo;

/**
 *
 * @author info2025
 */
public class Computador {
    private int id;
    private String nome;
    private String localizacao;
    private String enderecoip;
    private String configuracao;

    public Computador() {
    }
    
    public Computador(int id, String nome, String localizacao, String enderecoip, String configuracao) {
        this.id = id;
        this.nome = nome;
        this.localizacao = localizacao;
        this.enderecoip = enderecoip;
        this.configuracao = configuracao;
    }
    
    /**
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * @return the nome
     */
    public String getNome() {
        return nome;
    }

    /**
     * @param nome the nome to set
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     * @return the localizacao
     */
    public String getLocalizacao() {
        return localizacao;
    }

    /**
     * @param localizacao the localizacao to set
     */
    public void setLocalizacao(String localizacao) {
        this.localizacao = localizacao;
    }

    /**
     * @return the enderecoip
     */
    public String getEnderecoip() {
        return enderecoip;
    }

    /**
     * @param enderecoip the enderecoip to set
     */
    public void setEnderecoip(String enderecoip) {
        this.enderecoip = enderecoip;
    }

    /**
     * @return the configuracao
     */
    public String getConfiguracao() {
        return configuracao;
    }

    /**
     * @param configuracao the configuracao to set
     */
    public void setConfiguracao(String configuracao) {
        this.configuracao = configuracao;
    }
}
