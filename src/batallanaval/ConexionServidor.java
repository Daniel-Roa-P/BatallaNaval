
package batallanaval;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import org.apache.log4j.Logger;

public class ConexionServidor implements ActionListener {
    
    private Logger log = Logger.getLogger(ConexionServidor.class);
    private Socket socket; 
    private String usuario;
    private DataOutputStream salidaDatos;
    private String matriz;
    
    public ConexionServidor(Socket socket, String matriz, String usuario) {
        this.socket = socket;
        this.matriz = matriz;
        this.usuario = usuario;
        
        try {
            this.salidaDatos = new DataOutputStream(socket.getOutputStream());
        } catch (IOException ex) {
            log.error("Error al crear el stream de salida : " + ex.getMessage());
        } catch (NullPointerException ex) {
            log.error("El socket no se creo correctamente. ");
        }
    }
    
    public String enviarMatriz(Socket socket, String matriz, String usuario) {
        this.socket = socket;
        this.matriz = matriz;
        this.usuario = usuario;
        
        try {
            this.salidaDatos = new DataOutputStream(socket.getOutputStream());
        } catch (IOException ex) {
            log.error("Error al crear el stream de salida : " + ex.getMessage());
        } catch (NullPointerException ex) {
            log.error("El socket no se creo correctamente. ");
    
        }    
        return matriz;
    }

    
    
    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            salidaDatos.writeUTF(matriz);
        } catch (IOException ex) {
            log.error("Error al intentar enviar un mensaje: " + ex.getMessage());
        }
    }

}