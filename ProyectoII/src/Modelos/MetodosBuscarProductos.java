

/*

Ingeniero y Compañeros, para poder completar mi parte de Buscar productos Necesito que pueda existir ya la Base de Datos que vamos a Usar

Gracias Att ALEXANDER LOPEZ PALACIOS

*/
package Modelos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel; 

public class MetodosBuscarProductos {
//Pool metodospool = new Pool();//investrigar clase pool
DefaultTableModel ModeloTabla;
    
public void Buscar(String valor, String filtro, JTable jtabledatos){

    String [] columnas={"ID","Descripcion","cantidad","precio"};
    String [] registro=new String[4];
    ModeloTabla=new DefaultTableModel(null,columnas);      
    String SSQL = null;
    Connection conect = null;
    
    if(filtro.equals("descripcion")){
    
        SSQL= "SELECT id_producto, descripcion, cantidad, precio"
                 + "FROM productos WHERE descripcion LIKE '%"+valor+"%'";
        
    }else if(filtro.equals("codigo")){
    
        SSQL= "SELECT id_producto, descripcion, cantidad, precio"
                 + "FROM productos WHERE codigo LIKE '%"+valor+"%'";
    
    }else{
    
       JOptionPane.showMessageDialog(null, "No se encuetra el valor error");
    
    }
        
         
    try {

        //conect = metodospool.dataSource.getConnection();//falta clase de pool
       PreparedStatement st = conect.prepareStatement(SSQL);
        ResultSet rs = st.executeQuery();

        while (rs.next()){
          
            registro[0]=rs.getString("id_producto");
            registro[1]=rs.getString("descripcion");
            registro[2]=rs.getString("cantidad");
            registro[3]=rs.getString("precio");

          
            ModeloTabla.addRow(registro);
           
        }
        
        jtabledatos.setModel(ModeloTabla);

    } catch (SQLException e) {


        JOptionPane.showMessageDialog(null, e, "Error durante el procedimiento", JOptionPane.ERROR_MESSAGE);
    
    
    }finally{

        if(conect!=null){
        
            try {

                conect.close();

            } catch (SQLException ex) {

                JOptionPane.showMessageDialog(null, ex, "Error de desconexión", JOptionPane.ERROR_MESSAGE);

            }
        
        }
        
    }

}
}
