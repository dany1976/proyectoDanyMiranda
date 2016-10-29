/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Modelos;

/**
 *
 * @author Oscar
 */
public class Empleado {
    String idusuario;
    String contrasenia;
    String apellidos;
    String nombres;
    String privilegio;
    
    public Empleado(){
        idusuario="";
        contrasenia="";
        apellidos="";
        nombres="";
        privilegio="";
    }

    public String getDni() {
        return idusuario;
    }

    public void setDni(String idusuario) {
        this.idusuario = idusuario;
    }

    public String getContraseña() {
        return contrasenia;
    }

    public void setContraseña(String contraseña) {
        this.contrasenia = contraseña;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getPrivilegio() {
        return privilegio;
    }

    public void setPrivilegio(String privilegio) {
        this.privilegio = privilegio;
    }
    
    
}
