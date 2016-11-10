
package Modelos;


public class Agregar {
    String idproducto;
    String descripcion;
    String precio;
    String existencia;
    
    
    
 public Agregar (){
    idproducto="";
    descripcion="";
    precio="";
    existencia="";
    
} 

    public String getIdproducto() {
        return idproducto;
    }

    public void setIdproducto(String idproducto) {
        this.idproducto = idproducto;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getPrecio() {
        return precio;
    }

    public void setPrecio(String precio) {
        this.precio = precio;
    }

    public String getExistencia() {
        return existencia;
    }

    public void setExistencia(String existencia) {
        this.existencia = existencia;
    }
 
    
}

   