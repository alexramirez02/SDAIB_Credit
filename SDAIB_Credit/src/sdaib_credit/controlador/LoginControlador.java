/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sdaib_credit.controlador;

import java.awt.FlowLayout;
import javax.swing.JOptionPane;
import sdaib_credit.modelo.Usuario;
import sdaib_credit.vista.UIBienvenida;
import sdaib_credit.vista.UILoginUsuario;

/**
 * @author User
 */
public class LoginControlador implements ILoginUsuario {
    
    private UILoginUsuario uILoginUsuario;
    private UIBienvenida uIBienvenida;
    private Usuario usuario;
    private UsuarioControlador usuarioControlador;
    private PanelPrincipalControlador panelPrincipalControlador;
    
    public LoginControlador(){
        uILoginUsuario = new UILoginUsuario(this);
        uIBienvenida = new UIBienvenida();
        usuario = new Usuario();
        usuarioControlador = new UsuarioControlador();
        
        Main.uIPrincipal.getPanel().removeAll();
        Main.uIPrincipal.getPanel().setLayout(new FlowLayout());
        Main.uIPrincipal.getPanel().add(uILoginUsuario);
        Main.uIPrincipal.getPanel().updateUI();
    }

    @Override
    public void recibirUsername(String username) {
        usuario.setUsername(username);
    }

    @Override
    public void recibirPassword(String password) {
        usuario.setPassword(password);
    }

    @Override
    public void ingresar() {
        Usuario user = usuarioControlador.getUsuario(usuario.getUsername());
        if (user != null) {
            if (user.getPassword().equals(usuario.getPassword())) {
                Main.uIPrincipal.getPanel().removeAll();
                Main.uIPrincipal.getPanel().setLayout(new FlowLayout());
                Main.uIPrincipal.getPanel().add(uIBienvenida);
                Main.uIPrincipal.getPanel().updateUI();
            } else {
                JOptionPane.showMessageDialog(null, "La contraseña es incorrecta");
            }
        } else {
            JOptionPane.showMessageDialog(null, "El usuario no se encuentra registrado");
        }
    }

    @Override
    public void regresar() {
        panelPrincipalControlador = new PanelPrincipalControlador();
    }

}
