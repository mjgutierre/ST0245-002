import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Scanner;
import java.util.ArrayList;
import java.io.BufferedReader;
/** author 
 * @María José Gutiérrez, Paulina Ocampo
 * Version 1.0
 */
public class Read {
    public static HashMap <Long, Data> ReadData () throws IOException {
        HashMap <Long, Data> colection = new HashMap<>();
        String ID,x,y,name;
        String text = "";
        int cont= 0;

        try {
            FileReader reader= new FileReader ("Vertices.txt");
            BufferedReader content = new BufferedReader (reader);
            while ((text=content.readLine()) !=null) {
                String [] line = text.split(" ");
                ID = line[0]; 
                y = line[1]; 
                x = line [2];
                name = line [3];
                Data da = new Data(Long.parseLong(ID),Double.valueOf(x),Double.valueOf(y), name);
                colection.put(da.ID,da);
                cont ++;
            }
            content.close ();
        } catch (Exception e) {
            System.out.println("The document can´t be find" );
        }
        return colection;
    }
    public ArrayList<Triplet<Long, Long, Double>> readDirection() throws IOException  {
        ArrayList<Triplet<Long, Long, Double>> direction = new ArrayList<>();
        try{
            FileReader reader2  = new FileReader("Arcos.txt");
            BufferedReader cont2 = new BufferedReader(reader2);
            String line;
            int lineCount = 0;
            while((line = cont2.readLine()) != null) {
                if(lineCount != 0) {
                    String[] data = line.split(" ");
                    Long source= Long.parseLong(data[0]);
                    Long destination = Long.parseLong(data[1]);
                    Double distance = Double.parseDouble(data[2]);
                    Triplet<Long, Long, Double> c = new Triplet(source, destination, distance);
                    direction.add(c);
                    lineCount++;
                }
            }
            cont2.close();
        }catch (Exception e) {
            System.out.println("The document can´t be find");
        }
        return direction;
    }
}