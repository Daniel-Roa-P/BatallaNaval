package batallanaval;

import java.awt.Color;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class BatallaNaval extends JFrame implements ActionListener{

    public CampoBatalla campo = new CampoBatalla();
    public Archivos fu = new Archivos();
    public String[][] matriz;
    
    public JButton enviar = new JButton("Ubicar barcos");
    public JTextField cuadro1 = new JTextField();
    public JTextField cuadro2 = new JTextField();
    public JTextField cuadro3 = new JTextField();
    public JTextField cuadro4 = new JTextField();
    public JTextField cuadro5 = new JTextField();
    public JTextField cuadro6 = new JTextField();
    public JTextField cuadro7 = new JTextField();
    public JTextField cuadro8 = new JTextField();
    public JTextField cuadro9 = new JTextField();
    public JTextField cuadro10 = new JTextField();
    public JLabel texto1= new JLabel("MATRIZ PROPIA");
    public JLabel texto2= new JLabel("MATRIZ RIVAL");
    public JLabel texto3= new JLabel("Barco 1:");
    public JLabel texto4= new JLabel("Barco 2:");
    public JLabel texto5= new JLabel("Barco 3:");
    public JLabel texto6= new JLabel("Barco 4:");
    public JLabel texto7= new JLabel("Barco 5:");
    public JLabel texto8= new JLabel("X");
    public JLabel texto9= new JLabel("Y");
    JComboBox lista1 = new JComboBox();
    JComboBox lista2 = new JComboBox();
    JComboBox lista3 = new JComboBox();
    JComboBox lista4 = new JComboBox();
    JComboBox lista5 = new JComboBox();
    
    public static BatallaNaval bn;
    
    public BatallaNaval(){
        
        Container c=getContentPane();
        c.setLayout(null);
        this.getContentPane().setBackground(new Color(37,119,25));

        c.add(texto1);
        c.add(texto2);
        c.add(texto3);
        c.add(texto4);
        c.add(texto5);
        c.add(texto6);
        c.add(texto7);
        c.add(texto8);
        c.add(texto9);
        c.add(cuadro1);
        c.add(cuadro2);
        c.add(cuadro3);
        c.add(cuadro4);
        c.add(cuadro5);
        c.add(cuadro6);
        c.add(cuadro7);
        c.add(cuadro8);
        c.add(cuadro9);
        c.add(cuadro10);
        c.add(enviar);
        c.add(lista1);
        c.add(lista2);
        c.add(lista3);
        c.add(lista4);
        c.add(lista5);
        
        lista1.addItem("Vertical (2)");
        lista1.addItem("Horizontal (2)");
        lista2.addItem("Vertical (3)");
        lista2.addItem("Horizontal (3)");
        lista3.addItem("Vertical (3)");
        lista3.addItem("Horizontal (3)");
        lista4.addItem("Vertical (4)");
        lista4.addItem("Horizontal (4)");
        lista5.addItem("Vertical (5)");
        lista5.addItem("Horizontal (5)");
        
        enviar.addActionListener(this);
        
        texto1.setBounds(170, 420, 100, 20);
        texto1.setForeground(Color.WHITE);
        texto2.setBounds(670, 420, 100, 20);
        texto2.setForeground(Color.WHITE);
        texto3.setBounds(25,460,100,20);
        texto3.setForeground(Color.WHITE);
        texto4.setBounds(25,500,100,20);
        texto4.setForeground(Color.WHITE);
        texto5.setBounds(25,540,100,20);
        texto5.setForeground(Color.WHITE);
        texto6.setBounds(25,580,100,20);
        texto6.setForeground(Color.WHITE);
        texto7.setBounds(25,620,100,20);
        texto7.setForeground(Color.WHITE);
        texto8.setBounds(95,435,100,20);
        texto8.setForeground(Color.WHITE);
        texto9.setBounds(125,435,100,20);
        texto9.setForeground(Color.WHITE);
        
        cuadro1.setBounds(90,460,20,20);
        cuadro2.setBounds(120,460,20,20);
        cuadro3.setBounds(90,500,20,20);
        cuadro4.setBounds(120,500,20,20);
        cuadro5.setBounds(90,540,20,20);
        cuadro6.setBounds(120,540,20,20);
        cuadro7.setBounds(90,580,20,20);
        cuadro8.setBounds(120,580,20,20);
        cuadro9.setBounds(90,620,20,20);
        cuadro10.setBounds(120,620,20,20);
        
        lista1.setBounds(150,460,100,20);
        lista2.setBounds(150,500,100,20);
        lista3.setBounds(150,540,100,20);
        lista4.setBounds(150,580,100,20);
        lista5.setBounds(150,620,100,20);
        
        enviar.setBounds(25, 650, 120, 20);
        enviar.setBackground(Color.YELLOW);
        iniciarComponentes();
        
    }
    
    public void iniciarComponentes(){
        String archivo = fu.archivoAleatorio("../archivos");
        matriz = fu.fileToMatriz("../archivos/" + archivo);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        actualizarComponentes();
    }
    
    public void actualizarComponentes(){
        
        setLayout(null);
        add(campo);
        pack();
        setBounds(0, 0, 925, 730);
        campo.iniciarCampo(matriz);
        campo.setBounds(0, 0, 1300, 730);
        
    }
    
    public static void main(String[] args) {
        bn=new BatallaNaval();
        bn.setVisible(true);
    }

    public void validacionImpresion(int x, int y, int n,String oritentacion){
    
        if(x>0 && x<10 && y>0 && y<10){
                
                if(oritentacion.equals("Vertical ("+Integer.toString(n)+")") && (y+n)<=10){
                
                    for(int i=y;i<y+n;i++){
                        matriz[(x*5)+1][(i*5)+1]="v";
                    }
                }
                
                if(oritentacion.equals("Horizontal ("+Integer.toString(n)+")") && ((x+n)<=10)){
                
                    for(int i=x;i<x+n;i++){
                        matriz[(i*5)+1][(y*5)+1]="v";
                    }   
                }
            }
        
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        
        if(e.getSource()==enviar){
            
            validacionImpresion(Integer.parseInt(cuadro1.getText()),Integer.parseInt(cuadro2.getText()),2,lista1.getSelectedItem().toString());
            validacionImpresion(Integer.parseInt(cuadro3.getText()),Integer.parseInt(cuadro4.getText()),3,lista2.getSelectedItem().toString());
            validacionImpresion(Integer.parseInt(cuadro5.getText()),Integer.parseInt(cuadro6.getText()),3,lista3.getSelectedItem().toString());
            validacionImpresion(Integer.parseInt(cuadro7.getText()),Integer.parseInt(cuadro8.getText()),4,lista4.getSelectedItem().toString());
            validacionImpresion(Integer.parseInt(cuadro9.getText()),Integer.parseInt(cuadro10.getText()),5,lista5.getSelectedItem().toString());
            actualizarComponentes();
            
        }
    
    }
    
}
