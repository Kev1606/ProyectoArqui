package control;

import java.util.ArrayList;
import java.util.Properties;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

/**
 *
 * @author Sophya 
 */
public class AdminCorreo {
    
    /**
     * Constructor base de AdminCorreo
     */
    public AdminCorreo(){}
    
    /**
     * Método que se encarga de envíar los correos con la información de los sismos.
     * @param destin (String): dirección de correo de destino a la cual se enviará la info
     * @param asunto (String): texto que se usará como asunto en el correo.
     * @param cuerpo (String): información que se colocará en el cuerpo del correo, sobre algún sismo.
     * @throws MessagingException 
     */
    public void enviarConGMail(String destin, String asunto, String cuerpo) throws MessagingException {
        // Esto es lo que va delante de @gmail.com en tu cuenta de correo. Es quien envía.
        String remitente = "info.sismos.poo";                   //dirección info.sismos.poo@gmail.com
        //String remitente = "sophyafernanda"; 
        String clave = "ymrkyzvwlhrjwwmk";  
    
        Properties props = new Properties();
        props.put("mail.smtp.host", "smtp.gmail.com");          //servidor SMTP de Google
        props.setProperty("mail.smtp.starttls.enable", "true"); //conectar de manera segura al servidor SMTP
        props.put("mail.smtp.ssl.trust", "smtp.gmail.com");
        props.setProperty("mail.smtp.port", "587");             //puerto SMTP seguro de Google
        props.setProperty("mail.smtp.user", remitente);
        props.setProperty("mail.smtp.auth", "true");            //autenticación mediante usuario y clave
    
        Session session = Session.getDefaultInstance(props);
        MimeMessage message = new MimeMessage(session);
            message.setFrom(new InternetAddress(remitente));
            message.addRecipient(Message.RecipientType.TO, new InternetAddress(destin));   //Se podrían añadir varios de la misma manera
            message.setSubject(asunto);
            message.setText(cuerpo);
            Transport transport = session.getTransport("smtp");
            transport.connect("smtp.gmail.com", remitente, clave);
            transport.sendMessage(message, message.getAllRecipients());
    }
    
    /**
     * Método que prepara la información para el envío de los correos y llama al método enviarConGMail.
     * 
     * @throws MessagingException 
     */
    public void crearDatosCorreo(ArrayList<String> correos, String nombre) throws MessagingException{
       
        long inicioFuncion =  System.currentTimeMillis();
        String asunto ="SU TAREA FUE ENVIADA PARA CALIFICAR ";
        String cuerpo = "La tarea del curso de " + nombre +" fue enviada exitosamente. ";
        int contador = 1;           
        for (String correo : correos) {
                    long inicioCorreo =  System.nanoTime();
                    String destin = correo;
                    enviarConGMail(destin, asunto, cuerpo); 
                    System.out.println("\n\t-->Correo #" + contador + " de notificación enviado a "+destin);
                    long tiempoTotal = System.nanoTime()-inicioCorreo;
                    System.out.println("\n Duró " + tiempoTotal + " nanosegundos enviando el correo.");
                    contador++;
        }
        long tiempoTotal = System.currentTimeMillis()-inicioFuncion;
        System.out.println("\n Duró " + tiempoTotal + " milisegundos realizando la función.");
    }
}