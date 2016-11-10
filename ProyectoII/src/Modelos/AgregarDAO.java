
package Modelos;
import Modelos.Conexion;
import java.sql.*;
import javax.swing.JOptionPane;



public class AgregarDAO {
Conexion conexion;


    
    public void AgregarProducto(String idproducto, String descripcion, String precio, String existencia){
       
        Conexion conect = new Conexion();
        Connection conn;
        
        try
        {
            conect.conectar();
            conn = conect.getConexion();
            Statement comando = conn.createStatement();
            
            //INSERTAR UN REGISTRO A LA BASE DE DATOS 
            comando.executeUpdate("insert into productos() values('"+idproducto+"',"
                    + "'"+descripcion+"',"
                    + "'"+precio+"',"
                    + "'"+existencia+"')");
        }
        catch(Exception e)
        {
            JOptionPane.showMessageDialog(null, e);
        }
       
      
    }


}
