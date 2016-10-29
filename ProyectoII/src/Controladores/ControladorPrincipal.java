/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controladores;

import Modelos.MetodosBuscarProductos;
import Vistas.BuscarProductos;
import Vistas.JFprincipal;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

/**
 *
 * @author Julio
 */
public class ControladorPrincipal  implements ActionListener{
    JFprincipal VistaPrincipal = new JFprincipal();
    BuscarProductos VistaBuscar;
    
    
    public ControladorPrincipal(JFprincipal VistaPrincipal ){
       this.VistaPrincipal = VistaPrincipal;
        this.VistaPrincipal.btnb.addActionListener(this);
       
    }
    
    
    public void actionPerformed(ActionEvent E){
        if(VistaPrincipal.btnb == E.getSource()){
            
            VistaBuscar = new BuscarProductos(VistaPrincipal, true);
            VistaBuscar.setLocationRelativeTo(null);
            VistaBuscar.setVisible(true);
        }
    }
    
        
}
