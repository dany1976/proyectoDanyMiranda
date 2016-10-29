/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Modelos;
import java.sql.*;
/**
 *
 * @author Oscar
 */
public class EmpleadoDAO {
    Conexion conexion;
    
    public EmpleadoDAO(){
        conexion = new Conexion();
    }


public Empleado verificaUsuario(String idusuario, String contrasenia, String privilegio){
        Empleado empleado=null;
        Connection accesoDB = conexion.getConexion();
        try {
            
            PreparedStatement ps = accesoDB.prepareStatement("select * from usuarios where idusuario=? and contrasenia=? ");
            ps.setString(1, idusuario);
            ps.setString(2, contrasenia);
            ps.setString(3, privilegio);
            
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
               empleado = new Empleado();
               empleado.setDni(rs.getString(1));
               empleado.setContraseña(rs.getString(2));
               empleado.setApellidos(rs.getString(3));
               empleado.setNombres(rs.getString(4));
               empleado.setPrivilegio(rs.getString(5));
               return empleado;
            }
        } catch (Exception e) {
        }
        return empleado;
    }
}
