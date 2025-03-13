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
    
    private String msg;
    
    public MeuBean() {
        hello = new Hello();
        msg = "";
    }
    
    public void ola() {
        msg = "Olá, " + hello.getNome();
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

    /**
     * @return the msg
     */
    public String getMsg() {
        return msg;
    }

    /**
     * @param msg the msg to set
     */
    public void setMsg(String msg) {
        this.msg = msg;
    }
}