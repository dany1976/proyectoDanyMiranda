package Modelo;


import Modelos.Conexion;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;

public class MetodosBuscarProductosDAO {
    public ResultSet consulta = null;
    
    public MetodosBuscarProductosDAO(){
        
    }
    
    
    

    
    public void buscardatos (String codigo, String descripcion, Double precio, int existencia){
        Conexion conect = new Conexion();
        Connection conn;
        try
        {
            conect.conectar();
            conn = conect.getConexion();
            Statement comando = conn.createStatement();
            //ResultSet consulta = null;
            
            //BUSCAR UN REGISTRO A LA BASE DE DATOS
            consulta = comando.executeQuery("select * from productos where idcodigo = '"+codigo+"'");
           // consulta.last();
            if(consulta.next())
            {
            descripcion = consulta.getString("descripcion");
            precio = Double.parseDouble(consulta.getString("precio"));
            existencia = Integer.parseInt(consulta.getString("direccion"));
           
            }
            else
            {
                
                JOptionPane.showMessageDialog(null,"Registro no encontrado");
            }
        }
        catch(Exception e)
        {
            JOptionPane.showMessageDialog(null,"Error 00001"+e);
        } 
        
    }
}
