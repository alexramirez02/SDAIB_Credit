/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sdaib_credit.controlador;

import java.awt.FlowLayout;
import javax.swing.JOptionPane;
import sdaib_credit.modelo.Usuario;
import sdaib_credit.vista.UIRegistroUsuario;

/**
 *
 * @author User
 */
public class RegistroUsuarioControlador implements IRegistroUsuario{

    private UIRegistroUsuario uIRegistroUsuario;
    private Usuario usuario;
    private UsuarioControlador usuarioControlador;
    private PanelPrincipalControlador panelPrincipalControlador;
    
    public RegistroUsuarioControlador(){
        uIRegistroUsuario = new UIRegistroUsuario(this);
        usuario = new Usuario();
        usuarioControlador = new UsuarioControlador();
        
        Main.uIPrincipal.getPanel().removeAll();
        Main.uIPrincipal.getPanel().setLayout(new FlowLayout());
        Main.uIPrincipal.getPanel().add(uIRegistroUsuario);
        Main.uIPrincipal.getPanel().updateUI();
    }
    
    @Override
    public void recibeNombre(String nombre) {
        usuario.setNombre(nombre);
    }

    @Override
    public void recibeIdentificacion(String identificacion) {
       usuario.setIdentificacion(identificacion);
    }

    @Override
    public void recibeUsername(String username) {
        usuario.setUsername(username);
    }

    @Override
    public void recibePassword(String password) {
        usuario.setPassword(password);
    }

    @Override
    public void registrar() {
        Usuario user = usuarioControlador.getUsuario(usuario.getUsername());
        if(user != null){
            JOptionPane.showMessageDialog(null, "El usuario '" + user.getUsername() + "' ya se encuentra registrado");
            return;
        }
        boolean seRegistroCorrectamente = usuarioControlador.registrarUsuario(usuario);
        if(seRegistroCorrectamente){
            JOptionPane.showMessageDialog(null, "El usuario se ha registrado correctamente");
        }else{
            JOptionPane.showMessageDialog(null, "Ha ocurrido un error durante el registro");
            return;
        }
        panelPrincipalControlador = new PanelPrincipalControlador();
    }

    @Override
    public void cancelar() {
        panelPrincipalControlador = new PanelPrincipalControlador();
    }
    
}