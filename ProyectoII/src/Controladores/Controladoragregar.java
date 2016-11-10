
package Controladores;
import Modelos.*;
import Vistas.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

public class Controladoragregar implements ActionListener {
    
    JDAgregar vistaagregar = new JDAgregar(null,true);
    AgregarDAO modeloagregar = new AgregarDAO();
    
    public Controladoragregar(JDAgregar vistaAgregar, AgregarDAO modeloAgregar){
        this.modeloagregar = modeloAgregar;
        this.vistaagregar = vistaAgregar;
        this.vistaagregar.btnagregar.addActionListener(this);
        
        
        
    }
    
    public void InicializarAgregar(){
        
    }
    
    
    public void actionPerformed(ActionEvent e){
        if(e.getSource()== vistaagregar.btnagregar){
            
            String idproducto = vistaagregar.txtidproducto.getText();
            String descripcion = vistaagregar.txtdesc.getText();
            String precio = vistaagregar.txtpre.getText();
            String existencia = vistaagregar.txtexist.getText();
            
             modeloagregar.AgregarProducto(idproducto, descripcion, precio, existencia);
            
            
                JOptionPane.showMessageDialog(null, "Agregado");
            }else{
                JOptionPane.showMessageDialog(null,"No Agregado.");
            }            
        }
    }

