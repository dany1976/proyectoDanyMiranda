/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Controladores;
import javax.swing.*;

import Modelos.Empleado;
import Modelos.EmpleadoDAO;
import Vista.JFGerente;
import Vista.JFLogin;
import java.awt.event.*;

/**
 *
 * @author Oscar
 */
public class ControladorLogin implements ActionListener{
    JFLogin vistaLogin = new JFLogin();
    EmpleadoDAO modeloLogin = new EmpleadoDAO();
    Empleado empleado = new Empleado();
    
    public ControladorLogin(JFLogin vistaLogin, EmpleadoDAO modeloLogin){
        this.vistaLogin=vistaLogin;
        this.modeloLogin = modeloLogin;
        this.vistaLogin.btnIngresar.addActionListener(this);
    }
    
    public void InicializarLogin(){
        
    }
    
    public void actionPerformed(ActionEvent e){
        
        String dni= vistaLogin.txtDni.getText();
        String contraseña = String.valueOf(vistaLogin.txtContraseña.getPassword());
        String privilegio = String.valueOf(vistaLogin.cboPrivilegio.getSelectedItem());
        empleado = modeloLogin.verificaUsuario(dni, contraseña, privilegio);
        if(empleado==null){
            JOptionPane.showMessageDialog(vistaLogin, "Empleado con datos ingresados no encontrado.");
        }else{
            JOptionPane.showMessageDialog(vistaLogin, "Datos correctos.");
            JFGerente vistaG = new JFGerente();
            vistaG.lblBienvenida.setText("Bienvenido "+empleado.getNombres());
            ControladorGerente controladorG = new ControladorGerente(vistaG, modeloLogin);
            controladorG.InicializaGerente(dni, contraseña, privilegio);
            vistaG.setVisible(true);
            vistaG.setLocationRelativeTo(null);
            vistaLogin.setVisible(false); 
            
        }
    }
}
