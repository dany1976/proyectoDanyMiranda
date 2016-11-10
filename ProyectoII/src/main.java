
import Controladores.ControladorPrincipal;
import Controladores.Controladoragregar;
import Modelos.AgregarDAO;
import Vistas.JDAgregar;
import Vistas.JFprincipal;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Julio
 */
public class main {
    
    public static void main(String[] args) {
       /* 
        Conexion conexion = new Conexion(); 
        conexion.conectar();
        */
        JFprincipal frmPantallaPrincipal = new JFprincipal();
        ControladorPrincipal ControladorPrincipal = new ControladorPrincipal(frmPantallaPrincipal);
        frmPantallaPrincipal.setExtendedState(frmPantallaPrincipal.MAXIMIZED_BOTH);
        frmPantallaPrincipal.setVisible(true);
        
        JDAgregar vistaA = new JDAgregar(new JFprincipal(),true);
        AgregarDAO modeloA = new AgregarDAO();
        Controladoragregar controlaA = new Controladoragregar(vistaA, modeloA);
    
       
        vistaA.setVisible(true);
        vistaA.setLocationRelativeTo(null);
        // TODO code application logic here
    }
}
