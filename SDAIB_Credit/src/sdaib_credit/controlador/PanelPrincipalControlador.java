/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sdaib_credit.controlador;

import java.awt.FlowLayout;
import sdaib_credit.vista.UIPanelPrincipal;

/**
 *
 * @author User
 */
public class PanelPrincipalControlador {
    
    private UIPanelPrincipal uIPanelPrincipal;
    
    public PanelPrincipalControlador(){
        
        uIPanelPrincipal = new UIPanelPrincipal();
        
        Main.uIPrincipal.getPanel().removeAll();
        Main.uIPrincipal.getPanel().setLayout(new FlowLayout());
        Main.uIPrincipal.getPanel().add(uIPanelPrincipal);
        Main.uIPrincipal.getPanel().updateUI();
    }
    
    public void Login(){
        
    }
    public void Registro(){
        
    }
}
