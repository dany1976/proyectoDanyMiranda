/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Controladores;

import Modelos.Empleado;
import Modelos.EmpleadoDAO;
import Vista.JFGerente;
import java.awt.event.*;
import javax.swing.*;

/**
 *
 * @author Oscar
 */
public class ControladorGerente implements ActionListener{
    JFGerente vistaGerente = new JFGerente();
    EmpleadoDAO modeloGerente = new EmpleadoDAO();
    Empleado  empleado = new Empleado();
    String dni, contraseña, privilegio;
    
    public ControladorGerente(JFGerente vistaGerente, EmpleadoDAO modeloGerente){
        this.vistaGerente=vistaGerente;
        this.modeloGerente=modeloGerente;
        this.vistaGerente.btnDatosGerente.addActionListener(this);
    }
    
    public void InicializaGerente(String dni, String contraseña, String privilegio){
        this.dni = dni;
        this.contraseña=contraseña;
        this.privilegio=privilegio;
    }
    
    public void actionPerformed(ActionEvent e){
        empleado = modeloGerente.verificaUsuario(dni, contraseña, privilegio);
        JOptionPane.showMessageDialog(vistaGerente, "DATOS DE USUARIO GERENTE \n"+
                "Apellidos y Nombres: "+empleado.getApellidos()+", "+empleado.getNombres()+"\n"+
                "Privilegio: "+empleado.getPrivilegio());
    }
}
