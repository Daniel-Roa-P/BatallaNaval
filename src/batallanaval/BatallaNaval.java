package batallanaval;

import java.awt.Color;
import java.awt.Container;
import javax.swing.JFrame;

public class BatallaNaval extends JFrame{

    CampoBatalla campo = new CampoBatalla();
    Archivos fu = new Archivos();
    String[][] matriz;
    
    public BatallaNaval(){
        
        Container c=getContentPane();
        c.setLayout(null);
        this.getContentPane().setBackground(new Color(37,119,25));

        iniciarComponentes();
        
    }
    
    public void iniciarComponentes(){
        String archivo = fu.archivoAleatorio("../archivos");
        
        System.out.println(archivo);
        
        matriz = fu.fileToMatriz("../archivos/" + archivo);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);
        add(campo);
        pack();
        setBounds(0, 0, 925, 730);
        campo.iniciarCampo(matriz);
        campo.setBounds(0, 0, 1300, 730);
    }
    
    public static void main(String[] args) {
        BatallaNaval bn=new BatallaNaval();
        bn.setVisible(true);
    }
    
}
