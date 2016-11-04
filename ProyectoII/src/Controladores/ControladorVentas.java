/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controladores;

import Modelos.VentasDAO;
import Vistas.JDventas;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.sql.ResultSet;
import java.util.Calendar;
import java.util.GregorianCalendar;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Julio
 */
public class ControladorVentas implements ActionListener{
    JDventas vistaventas;
    public float grantotal;
    DefaultTableModel modelo = new DefaultTableModel();
    public  ControladorVentas (JDventas vistaventas){
        this.vistaventas = vistaventas;

        this.vistaventas.btnventa.addActionListener(this);
        this.vistaventas.btndetalle.addActionListener(this);
        this.vistaventas.txtfecha.addActionListener(this);
        this.vistaventas.txtnit.addActionListener(this);
        this.vistaventas.txtdireccion.addActionListener(this);
        this.vistaventas.txtcantidad.addActionListener(this);
        
        
        
    }
    public void actionPerformed(ActionEvent E){
         if (vistaventas.txtfecha== E.getSource())
         {
             //aqui mando a buscar la factura y que me mande la fecha
             
             Calendar calen = new GregorianCalendar();
            int anio = calen.get(Calendar.YEAR);
            int mes = calen.get(Calendar.MONTH)+1;
            int dia = calen.get(Calendar.DAY_OF_MONTH);
            
            vistaventas.txtfecha.setText(anio+"-"+mes+"-"+dia);
            
            
            
            VentasDAO nuevaVenta = new VentasDAO();
         ResultSet datosobtenidos;
         ResultSet consulta;
         
         datosobtenidos =  nuevaVenta.Buscaras(Integer.parseInt(vistaventas.txtfactura.getText()));
            
            
                JOptionPane.showMessageDialog(null,"Existe una factura anterior ");
                
                try
         {
             if(datosobtenidos.next())
             {
                 int variable2  = datosobtenidos.getInt("Numero_Factura");
                 int suma= variable2+1;
                 
                 vistaventas.txtfactura.setText(datosobtenidos.getString(""+suma));
            
            
            
             }else{
                 JOptionPane.showMessageDialog(null, "NO HAY REGISTROS PARA EL CÓDIGO");
             }
             
                 
         }catch(Exception e){
                 
                     JOptionPane.showMessageDialog(null, "Hubo un error al obtener los datos"+e);
                 }
            
         }else
        if (vistaventas.txtnit== E.getSource())
         {
             VentasDAO nuevaVenta = new VentasDAO();
         ResultSet datosobtenidos;
         ResultSet consulta;
         
         datosobtenidos =  nuevaVenta.Buscar(Integer.parseInt(vistaventas.txtnit.getText()));
            
            
                JOptionPane.showMessageDialog(null,"Existe el Cliente ");
                
                try
         {
             if(datosobtenidos.next())
             {
                 vistaventas.txtcliente.setText(datosobtenidos.getString("nombre"));
            vistaventas.txtcliente.setText(datosobtenidos.getString("direccion"));
            
            
             }else{
                 JOptionPane.showMessageDialog(null, "NO HAY REGISTROS PARA EL CÓDIGO");
             }
             
                 
         }catch(Exception e){
                 
                     JOptionPane.showMessageDialog(null, "Hubo un error al obtener los datos"+e);
                 }        // TODO ad
             }
        else
            if(vistaventas.txtdireccion== E.getSource()){
                
                VentasDAO nuevaVentaa = new VentasDAO();
    nuevaVentaa.GuardaCliente(Integer.parseInt(vistaventas.txtnit.getText()), vistaventas.txtcliente.getText(), vistaventas.txtdireccion.getText());
            
            }else
                if(vistaventas.txtcodigo== E.getSource()){
                    
                    
                VentasDAO nuevaVenta = new VentasDAO();
         ResultSet datosobtenidos;
         ResultSet consulta;
         
         datosobtenidos =  nuevaVenta.Buscara(Integer.parseInt(vistaventas.txtcodigo.getText()));
            
            
                JOptionPane.showMessageDialog(null,"Existe el producto ");
                
                try
         {
             if(datosobtenidos.next())
             {
                 vistaventas.txtdescripcion.setText(datosobtenidos.getString("descripcion"));
            vistaventas.txtprecio.setText(datosobtenidos.getString("precio"));
            
            vistaventas.txtexistencia.setText(datosobtenidos.getString("existencia"));
            
            
            
             }else{
                 JOptionPane.showMessageDialog(null, "NO HAY REGISTROS PARA EL CÓDIGO");
             }
             
                 
         }catch(Exception e){
                 
                     JOptionPane.showMessageDialog(null, "Hubo un error al obtener los datos"+e);
                 }        // TODO ad
             }
        else
                    if(vistaventas.txtcantidad== E.getSource())
                    {
                        grantotal = grantotal + (Integer.parseInt(vistaventas.txtcantidad.getText())*Float.parseFloat(vistaventas.txtprecio.getText()));
                vistaventas.txttotal.setText(Float.toString(grantotal));
                
                   Object[] fila = new Object[5];
                   fila[0] = vistaventas.txtdescripcion.getText();
                   fila[1] = vistaventas.txtprecio.getText();
                   fila[2] = vistaventas.txtcantidad.getText();
                   fila[3] = Float.parseFloat(vistaventas.txtprecio.getText())*Integer.parseInt(vistaventas.txtcantidad.getText());
                   fila[4] = vistaventas.txtcodigo.getText();
                   modelo.addRow(fila);
                    
                    }else
        if(vistaventas.btnventa== E.getSource()){
        VentasDAO nuevaVentaas = new VentasDAO();
                          
        nuevaVentaas.GuardarVenta(Integer.parseInt(vistaventas.txttotal.getText()),vistaventas.txtfecha.getText(),Integer.parseInt(vistaventas.txtcodigo.getText()), Integer.parseInt(vistaventas.txtfactura.getText()));
    
        VentasDAO NuevaEdicion = new VentasDAO();
    String Edicion;
    int exist;
             int c= Integer.parseInt(vistaventas.txtexistencia.getText());
             int x = Integer.parseInt(vistaventas.txtcantidad.getText());
             exist= c- x;
        Edicion = NuevaEdicion.Editar(exist, Integer.parseInt(vistaventas.txtcodigo.getText()));
        
        JOptionPane.showMessageDialog(null, Edicion);
        
                        }
         else
         if(vistaventas.btndetalle== E.getSource())
         {
              VentasDAO nuevaBuscada = new VentasDAO();
         ResultSet datosobtenidos;
         ResultSet consulta;
         
         datosobtenidos =  nuevaBuscada.BuscaraDetalle(Integer.parseInt(vistaventas.txtnit.getText()));
            
            
                JOptionPane.showMessageDialog(null,"siiii ");
                
                try
         {
             if(datosobtenidos.next())
             {
                 
                         int variable  = datosobtenidos.getInt("idbuscado");
            
            
                         for(int i=0;i<modelo.getRowCount();i++)
                    {
                        String a=modelo.getValueAt(i, 0).toString();
                        String b=modelo.getValueAt(i, 1).toString();
                        String c=modelo.getValueAt(i, 2).toString();
                        String d=modelo.getValueAt(i, 3).toString();
                        String f=modelo.getValueAt(i, 4).toString();
                        
                    }
                      VentasDAO nuevoguardado = new VentasDAO();
                          
        nuevoguardado.GuardarDetalle(variable, 4, 3);
       
                         
                         
             }else{
                 JOptionPane.showMessageDialog(null, "NO HAY REGISTROS PARA EL CÓDIGO");
             }
             
                 
         }catch(Exception e){
                 
                     JOptionPane.showMessageDialog(null, "Hubo un error al obtener los datos"+e);
                 } 
         
                
                
         }
         
    }
            
            
            
         
    
}
