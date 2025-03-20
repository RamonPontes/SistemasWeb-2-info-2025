/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bean;

import java.io.Serializable;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import vo.Login;

/**
 *
 * @author info2025
 */
@ManagedBean
@SessionScoped
public class ProgramaBean implements Serializable {
    private Login login = new Login();
    
    public String loga() {
        if (login.getLogin().equals("admin") && login.getSenha().equals("senha")) {
            return "menu";
        } else {
            return null;
        }
    }

    /**
     * @return the login
     */
    public Login getLogin() {
        return login;
    }

    /**
     * @param login the login to set
     */
    public void setLogin(Login login) {
        this.login = login;
    }
    
    
}
