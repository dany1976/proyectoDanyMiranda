package Modelos;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;
import Vistas.JDventas;

/**
 *
 * @author Guillermo
 */
public class VentasDAO {
    String fecha;
    int nit;
    String direccion;
    int numfac;
    String Cliente;
    int codigo;
    String descrip;
    int precio;
    int cantidad;
    int existencia;

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public int getNit() {
        return nit;
    }

    public void setNit(int nit) {
        this.nit = nit;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public int getNumfac() {
        return numfac;
    }

    public void setNumfac(int numfac) {
        this.numfac = numfac;
    }

    public String getCliente() {
        return Cliente;
    }

    public void setCliente(String Cliente) {
        this.Cliente = Cliente;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getDescrip() {
        return descrip;
    }

    public void setDescrip(String descrip) {
        this.descrip = descrip;
    }

    public int getPrecio() {
        return precio;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public int getExistencia() {
        return existencia;
    }

    public void setExistencia(int existencia) {
        this.existencia = existencia;
    }

    public Connection getConn() {
        return conn;
    }

    public void setConn(Connection Conn) {
        this.conn = Conn;
    }

    public Conexion getConect() {
        return conect;
    }

    public void setConect(Conexion conect) {
        this.conect = conect;
    }

    public ResultSet getConsulta() {
        return consulta;
    }

    public void setConsulta(ResultSet consulta) {
        this.consulta = consulta;
    }
    
    
       Connection conn;
    Conexion conect = new Conexion();
    ResultSet consulta;
    public ResultSet Buscar(int nit){
        
        try{
        JOptionPane.showMessageDialog(null, conect.conectar());
            conn = conect.getConexion();
            Statement comando = conn.createStatement();
            ResultSet datosobtenidos;
            
        
           datosobtenidos = comando.executeQuery("select * from clientes where nit = '"+nit);
            
            
            
        }catch(Exception e)
        {
            JOptionPane.showMessageDialog(null, "Ha ocurrido un error" + e);
   
        }
         return consulta;
    }
    
    public ResultSet Buscara(int idproducto){
        
        try{
        JOptionPane.showMessageDialog(null, conect.conectar());
            conn = conect.getConexion();
            Statement comando = conn.createStatement();
            ResultSet datosobtenidos;
            
        
            datosobtenidos = comando.executeQuery("select * from productos where idproducto= '"+idproducto);
            
            
            
        }catch(Exception e)
        {
            JOptionPane.showMessageDialog(null, "Ha ocurrido un error" + e);
   
        }
         return consulta;
    }
    
    public String GuardarVenta(int monto, String fecha, int idproducto ,int numfac){
        Conexion conect = new Conexion();
     Connection Conn;
     try{
           Conn = conect.getConexion();
            Statement Comando = Conn.createStatement();
            
            Comando.executeUpdate("insert into ventas() values('"+monto+"','"+fecha+"','"+idproducto+"','"+numfac+"')");
            Conn.close();
            return "registro de Anticipo Agregado Exitosamente";
        }
        catch(Exception e){
            return "Ocurrio un error al intentar agregar registro"+e;
        }
    }
    
    public String GuardaCliente(int nit, String direccion, String nombres){
        Conexion conect = new Conexion();
     Connection Conn;
     try{
           Conn = conect.getConexion();
            Statement Comando = Conn.createStatement();
            
            Comando.executeUpdate("insert into clientes() values('"+nit+"','"+direccion+"','"+nombres+"')");
            Conn.close();
            return "registro de Anticipo Agregado Exitosamente";
        }
        catch(Exception e){
            return "Ocurrio un error al intentar agregar registro"+e;
        }
    }
    
    public ResultSet Buscaras(int numfac){
        
        try{
        JOptionPane.showMessageDialog(null, conect.conectar());
            conn = conect.getConexion();
            Statement comando = conn.createStatement();
            ResultSet consulta;
            
        
            consulta = comando.executeQuery("select max(NumFactura) as Numero_Factura from ventas");
            
            
            
        }catch(Exception e)
        {
            JOptionPane.showMessageDialog(null, "Ha ocurrido un error" + e);
   
        }
         return consulta;
    }
    public ResultSet BuscaraDetalle(int idventa){
        
        try{
        JOptionPane.showMessageDialog(null, conect.conectar());
            conn = conect.getConexion();
            Statement comando = conn.createStatement();
            ResultSet consulta;
            
        
            consulta = comando.executeQuery("SELECT MAX(idventa) as idbuscado from  ventas");
            
            
            
        }catch(Exception e)
        {
            JOptionPane.showMessageDialog(null, "Ha ocurrido un error" + e);
   
        }
         return consulta;
    }
     
     public String GuardarDetalle(int idventa, int idproducto, int subtotal){
        Conexion conect = new Conexion();
     Connection Conn;
     try{
           Conn = conect.getConexion();
            Statement Comando = Conn.createStatement();
            
            Comando.executeUpdate("insert into ventas() values('"+idventa+"','"+idproducto+"','"+subtotal+"')");
            Conn.close();
            return "registro de Anticipo Agregado Exitosamente";
        }
        catch(Exception e){
            return "Ocurrio un error al intentar agregar registro"+e;
        }
    }
     public String Editar( int existencia, int idproducto){
        
        String respuesta;
        
        try{
            conect.conectar();
            conn = conect.getConexion();
            Statement comando = conn.createStatement();
           
            //Editar registro
            
                comando.executeUpdate("update productos set existencia = '"+existencia+"' where idproducto = "+idproducto);
            respuesta = "Registro actualizado exitosamente";
            
            return respuesta;
        }
        
        catch (Exception e){
            return "Hubo un error al momento de actualizar..."+e;
        }
    }
}
    

    
    
