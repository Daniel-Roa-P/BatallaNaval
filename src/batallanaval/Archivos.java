
package batallanaval;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Random;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Archivos {
    
    public int getFileRowsCount(String filePath) {
        int rows = 0;
        try {
            Scanner sc = new Scanner(new File(getClass().getResource(filePath).getPath()));
            while (sc.hasNext()) {
                sc.nextLine();
                rows++;
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Archivos.class.getName()).log(Level.SEVERE, null, ex);
        }
        return rows;
    }

    public int getFileColsCount(String filePath) {
        int cols = 0;
        try {
            Scanner sc = new Scanner(new File(getClass().getResource(filePath).getPath()));
            while (sc.hasNext()) {
                int count = sc.nextLine().split(" ").length;
                if (count > cols) {
                    cols = count;
                }
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Archivos.class.getName()).log(Level.SEVERE, null, ex);
        }
        return cols;
    }

    public String[][] fileToMatriz(String filePath) {
        String[][] matriz = new String[getFileRowsCount(filePath)][getFileColsCount(filePath)];
        int fila = 0;
        String[] linea;
        try {
            Scanner sc = new Scanner(new File(getClass().getResource(filePath).getPath()));
            while (sc.hasNext()) {
                int col = 0;
                linea = sc.nextLine().split(" ");
                for (int i = 0; i < linea.length; i++) {
                    matriz[fila][i] = linea[i];
                }
                fila++;
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Archivos.class.getName()).log(Level.SEVERE, null, ex);
        }
        return matriz;
    }
    
    public String archivoAleatorio(String filePath){
        Random r = new Random();
        File f = new File(getClass().getResource(filePath).getPath());
        String[] lista = f.list();
        return lista[r.nextInt(lista.length)];
    }
    
}
