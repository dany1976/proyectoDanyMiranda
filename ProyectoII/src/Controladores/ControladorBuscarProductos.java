/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controladores;

import Modelo.MetodosBuscarProductos;
import Modelo.MetodosBuscarProductosDAO;
import Vistas.BuscarProductos;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JOptionPane;

/**
 *
 alexander lopez palacios
 */
public class ControladorBuscarProductos implements ActionListener, KeyListener {
    
    BuscarProductos vistabuscar = new BuscarProductos();
    MetodosBuscarProductos modelobuscar = new MetodosBuscarProductos();
    MetodosBuscarProductosDAO modelobuscardao = new MetodosBuscarProductosDAO();
    
    
    public ControladorBuscarProductos(){
        
        this.modelobuscar=modelobuscar;
        this.modelobuscardao=modelobuscardao;
        this.vistabuscar=vistabuscar;
        
        
        
        this.vistabuscar.btnbuscar.addActionListener(this);
        this.vistabuscar.txtbuscar.addKeyListener((KeyListener) this);
        this.vistabuscar.txtdescripcion.addKeyListener((KeyListener) this);
        this.vistabuscar.txtprecio.addKeyListener((KeyListener) this);
        this.vistabuscar.txtexistencia.addKeyListener((KeyListener) this);
    }

    
    
    
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource().equals(vistabuscar.btnbuscar)){
          
          
      }
    }

    @Override
    public void keyTyped(KeyEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void keyPressed(KeyEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void keyReleased(KeyEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
}
