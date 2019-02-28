
package batallanaval;

import Miniaturas.Muros;
import Miniaturas.Numero;
import java.awt.Canvas;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.Iterator;


public class CampoBatalla extends Canvas{
    
    BufferedImage imgBuffer,imgBuffer2;
    String[][] matriz;
    ArrayList<Sprites> rocas,rocasRivales;
 
    public CampoBatalla(){
        
        rocas = new ArrayList<>();
        rocasRivales  = new ArrayList<>();
        imgBuffer = new BufferedImage(1090, 730, BufferedImage.TRANSLUCENT);
        imgBuffer2 = new BufferedImage(1090, 730, BufferedImage.TRANSLUCENT);
    }
    
    public void iniciarCampo(String[][] matriz) {
        this.matriz = matriz;
        for (int f = 0; f < matriz.length; f++) {
            for (int c = 0; c < matriz[f].length; c++) {
                if (matriz[f][c].equals("u")) {
                    rocas.add(new Numero(f * 1, c * 45,"uno"));
                } else if (matriz[f][c].equals("U")) {
                    rocas.add(new Numero(f * 45, c * 1,"uno"));
                }    else if (matriz[f][c].equals("d")) {
                    rocas.add(new Numero(f * 0, c * 85,"dos"));
                } else if (matriz[f][c].equals("D")) {
                    rocas.add(new Numero(f * 85, c * 0,"dos"));
                }  else if (matriz[f][c].equals("t")) {
                    rocas.add(new Numero(f * 0, c * 125,"tres"));
                } else if (matriz[f][c].equals("T")) {
                    rocas.add(new Numero(f * 125, c * 0,"tres"));
                } else if (matriz[f][c].equals("c")) {
                    rocas.add(new Numero(f * 0, c * 165,"cuatro"));
                } else if (matriz[f][c].equals("C")) {
                    rocas.add(new Numero(f * 165, c * 0,"cuatro"));
                }  else if (matriz[f][c].equals("q")) {
                    rocas.add(new Numero(f * 0, c * 205,"cinco"));
                } else if (matriz[f][c].equals("Q")) {
                    rocas.add(new Numero(f * 205, c * 0,"cinco"));
                }   else if (matriz[f][c].equals("x")) {
                    rocas.add(new Numero(f * 0, c * 245,"seis"));
                } else if (matriz[f][c].equals("X")) {
                    rocas.add(new Numero(f * 245, c * 0,"seis"));
                }  else if (matriz[f][c].equals("s")) {
                    rocas.add(new Numero(f * 0, c * 285,"siete"));
                } else if (matriz[f][c].equals("S")) {
                    rocas.add(new Numero(f * 285, c * 0,"siete"));
                } else if (matriz[f][c].equals("o")) {
                    rocas.add(new Numero(f * 0, c * 325,"ocho"));
                } else if (matriz[f][c].equals("O")) {
                    rocas.add(new Numero(f * 325, c * 0,"ocho"));
                }  else if (matriz[f][c].equals("n")) {
                    rocas.add(new Numero(f * 0, c * 365,"nueve"));
                } else if (matriz[f][c].equals("N")) {
                    rocas.add(new Numero(f * 365, c * 0,"nueve"));
                } 

            }
        }
        
        for (int f = 0; f < matriz.length; f++) {
            for (int c = 0; c < matriz[f].length; c++) {
                 if (matriz[f][c].equals("1")) {
                    rocas.add(new Muros(f * 8, c * 8));
                }
            }
        }
        
        for (int f = 0; f < matriz.length; f++) {
            for (int c = 0; c < matriz[f].length; c++) {
                if (matriz[f][c].equals("u")) {
                    rocasRivales.add(new Numero(f * 1, c * 45,"unoM"));
                } else if (matriz[f][c].equals("U")) {
                    rocasRivales.add(new Numero(f * 45, c * 1,"unoM"));
                }    else if (matriz[f][c].equals("d")) {
                    rocasRivales.add(new Numero(f * 0, c * 85,"dosM"));
                } else if (matriz[f][c].equals("D")) {
                    rocasRivales.add(new Numero(f * 85, c * 0,"dosM"));
                }  else if (matriz[f][c].equals("t")) {
                    rocasRivales.add(new Numero(f * 0, c * 125,"tresM"));
                } else if (matriz[f][c].equals("T")) {
                    rocasRivales.add(new Numero(f * 125, c * 0,"tresM"));
                } else if (matriz[f][c].equals("c")) {
                    rocasRivales.add(new Numero(f * 0, c * 165,"cuatroM"));
                } else if (matriz[f][c].equals("C")) {
                    rocasRivales.add(new Numero(f * 165, c * 0,"cuatroM"));
                }  else if (matriz[f][c].equals("q")) {
                    rocasRivales.add(new Numero(f * 0, c * 205,"cincoM"));
                } else if (matriz[f][c].equals("Q")) {
                    rocasRivales.add(new Numero(f * 205, c * 0,"cincoM"));
                }   else if (matriz[f][c].equals("x")) {
                    rocasRivales.add(new Numero(f * 0, c * 245,"seisM"));
                } else if (matriz[f][c].equals("X")) {
                    rocasRivales.add(new Numero(f * 245, c * 0,"seisM"));
                }  else if (matriz[f][c].equals("s")) {
                    rocasRivales.add(new Numero(f * 0, c * 285,"sieteM"));
                } else if (matriz[f][c].equals("S")) {
                    rocasRivales.add(new Numero(f * 285, c * 0,"sieteM"));
                } else if (matriz[f][c].equals("o")) {
                    rocasRivales.add(new Numero(f * 0, c * 325,"ochoM"));
                } else if (matriz[f][c].equals("O")) {
                    rocasRivales.add(new Numero(f * 325, c * 0,"ochoM"));
                }  else if (matriz[f][c].equals("n")) {
                    rocasRivales.add(new Numero(f * 0, c * 365,"nueveM"));
                } else if (matriz[f][c].equals("N")) {
                    rocasRivales.add(new Numero(f * 365, c * 0,"nueveM"));
                } 

            }
        }
        
        for (int f = 0; f < matriz.length; f++) {
            for (int c = 0; c < matriz[f].length; c++) {
                 if (matriz[f][c].equals("1")) {
                    rocasRivales.add(new Muros(f * 8, c * 8));
                }
            }
        }
    }
    
    @Override
    public void paint(Graphics g) {
        //super.paint(g); //To change body of generated methods, choose Tools | Templates.
    
        Graphics miG = imgBuffer.getGraphics();
        Graphics miG2 = imgBuffer2.getGraphics();
        //miG.drawImage(new ImageIcon(getClass().getResource("../imagenes/fondo.png")).getImage(), 0, 0, null);
        miG.clearRect(0, 0, 1300, 410);
        
        for (Iterator<Sprites> iterator = rocas.iterator(); iterator.hasNext();) {
            Sprites next = iterator.next();
            next.draw(miG);

        }
        
        for (Iterator<Sprites> iterator = rocasRivales.iterator(); iterator.hasNext();) {
            Sprites next = iterator.next();
            next.draw(miG2);

        }
        
        g.drawImage(imgBuffer, 0, 0, this);
        g.drawImage(imgBuffer2, 500, 0, this);
    }
    
    
}
