/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bean;

import javax.faces.bean.ManagedBean;
import vo.Hello;

/**
 *
 * @author info2025
 */
@ManagedBean
public class MeuBean {
    private Hello hello;
    
    public MeuBean() {
        hello = new Hello();
    }

    /**
     * @return the hello
     */
    public Hello getHello() {
        return hello;
    }

    /**
     * @param hello the hello to set
     */
    public void setHello(Hello hello) {
        this.hello = hello;
    }
    
    
}
