/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sdaib_credit.controlador;

import sdaib_credit.vista.UIPrincipal;

/**
 * @author User
 */
public class Main {
    
    public static UIPrincipal uIPrincipal;
    public static PanelPrincipalControlador panelPrincipalControlador;
    
    public Main(){
        uIPrincipal = new UIPrincipal();
        panelPrincipalControlador = new PanelPrincipalControlador();
    }
    
    public static void main(String[] args) {
        new Main();
    }
    
}
