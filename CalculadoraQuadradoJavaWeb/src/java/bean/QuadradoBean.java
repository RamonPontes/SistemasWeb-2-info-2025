/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bean;

import javax.faces.bean.ManagedBean;

/**
 *
 * @author info2025
 */
@ManagedBean
public class QuadradoBean {
    private float lado, resultado;
    
    public void calcular() {
        resultado = lado * lado;
    }
        
    /**
     * @return the lado
     */
    public float getLado() {
        return lado;
    }

    /**
     * @param lado the lado to set
     */
    public void setLado(float lado) {
        this.lado = lado;
    }

    /**
     * @return the resultado
     */
    public float getResultado() {
        return resultado;
    }

    /**
     * @param resultado the resultado to set
     */
    public void setResultado(float resultado) {
        this.resultado = resultado;
    }
}
