/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelos;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author Julio
 */
//213.136.90.177
public class Conexion {
    Connection conn;
    
    public String conectar()
    {
        try
        {
        Class.forName("com.mysql.jdbc.Driver");
        conn = DriverManager.getConnection("jdbc:mysql://www.miumghuehue.com/miumghuehue_tienda", "root","");
        return "Se conecto a la base de datos";
        }
        catch(Exception e)
                {
                    return "dio el error "+ e;
                }
    }
    
    public Connection getConexion()
    {
        return conn;
    }
}
