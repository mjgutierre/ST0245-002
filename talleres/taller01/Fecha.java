import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class Fecha {
    private int dia;
    private int mes;
    private int año;

    public static final String separador = ",";

    public void LeerDatos (String archivo) {
        try { 
            FileReader lector = new FileReader ("fechas.csv");
            BufferedReader contenido = new BufferedReader (lector);
            String linea = contenido.readLine();
            while ((linea = contenido.readLine())!= null) {
                String [] lineas = linea.split (separador);
                String fecha = lineas [0];
                mes= Integer.parseInt (fecha.substring (0,2));
                dia= Integer.parseInt (fecha.substring (3,4));
                año= Integer.parseInt (fecha.substring (6,9));

            }
        }       
        catch   (Exception e) {
            System.out.print ("Error ");
        }   
    }

    public Fecha(int dia, int mes, int año) {
        this.dia= dia;
        this.mes= mes;
        this.año= año;
    }

    public int dia() {
        return this.dia;
    }

    public int mes() {
        return this.mes;
    }

    public int año() {
        return this.año;
    }

    public int comparar(Fecha otra) {

        if (this.dia < otra.dia) {
            return -1;
        }
        if (this.dia > otra.dia){
            return 1;
        }
        if (this.mes < otra.mes) {
            return -1;
        }
        if (this.mes > otra.mes){
            return 1;
        }
        if (this.año > otra.año){
            return -1;
        }
        if (this.año > otra.año){
            return 1;
        }
        return 0;
    }

    public String toString() {
        return dia()+ "," + mes()+ "," + año();
    }
}
