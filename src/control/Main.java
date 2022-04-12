package control;


import java.util.ArrayList;
import javax.mail.MessagingException;


/**
 *
 * @author Sophya
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
//--------------------------Tráfico de Datos -----------------------------------------------------
        int n = 60;
        String nombre = "Arquitectura de Computadoras";
        AdminCorreo adminCorreo = new AdminCorreo();
        ArrayList<String> correos = new ArrayList<>();
        for(int i=0; i<n; i++){
            correos.add("arqui.prubeas2022@gmail.com");
            //correos.add("proyecto.arqui.2022@gmail.com");
            //correos.add("sophyafernanda@gmail.com");
        }

        try{
            adminCorreo.crearDatosCorreo(correos, nombre);
        }
        catch (MessagingException e){
            System.out.println("Error al enviar el correo.");
        }
        // TODO code application logic here
    
//----------------------------Medición de la ALU-----------------------------------------
//    Subconjunto subconjunto = new Subconjunto();
//    int j = 100;
//    ArrayList<Integer> listaNumeros = new ArrayList<> ();  
//    for(int i=0; i<=j; i++){
//        listaNumeros.add((int)(Math.random() * 900+100));
//    }
//    subconjunto.operaciones(listaNumeros);

}
}