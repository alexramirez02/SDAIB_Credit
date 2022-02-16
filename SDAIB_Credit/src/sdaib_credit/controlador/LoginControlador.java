/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sdaib_credit.controlador;

import java.awt.FlowLayout;
import sdaib_credit.vista.UIBienvenida;
import sdaib_credit.vista.UILoginUsuario;

/**
 * @author User
 */
public class LoginControlador implements ILoginUsuario {
    
    private UILoginUsuario uILoginUsuario;
    private UIBienvenida uIBienvenida;
    
    public LoginControlador(){
        uILoginUsuario = new UILoginUsuario(this);
        uIBienvenida = new UIBienvenida();
        
        Main.uIPrincipal.getPanel().removeAll();
        Main.uIPrincipal.getPanel().setLayout(new FlowLayout());
        Main.uIPrincipal.getPanel().add(uILoginUsuario);
        Main.uIPrincipal.getPanel().updateUI();
    }

    @Override
    public void recibirUserName() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void recibirPassword() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void ingresar() {
        //
        
        Main.uIPrincipal.getPanel().removeAll();
        Main.uIPrincipal.getPanel().setLayout(new FlowLayout());
        Main.uIPrincipal.getPanel().add(uIBienvenida);
        Main.uIPrincipal.getPanel().updateUI();
    }
    
}
