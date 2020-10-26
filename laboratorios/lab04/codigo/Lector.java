/**
 * Lector 
 * @version 25/10/2020
 */

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Collections; 
public class Lector{
    LinkedList<Double> a = new LinkedList();
    LinkedList<Double> b = new LinkedList();
    LinkedList<Double> c = new LinkedList();
    LinkedList<Bees> bees=new LinkedList();
    
     public Lector() {
        bees = new LinkedList<>();
        a = new LinkedList<>();
        b = new LinkedList<>();
        c = new LinkedList<>();
    }
     public void LecturaArchivo(String Archivo) throws IOException {
        try (BufferedReader nr=new BufferedReader(new FileReader(Archivo))){
            String line;
            while ((line=nr.readLine())!=null){
                splitString(line);
            } 
        } catch (IOException e){
            e.printStackTrace();
        }
        getMaxMin();
    }       
    public void splitString(String x){
        String [] str=x.split(",");  
        try{
            a.addFirst(Double.parseDouble(str[0]));
            b.addFirst(Double.parseDouble(str[1]));
            c.addFirst(Double.parseDouble(str[2]));
            Bees bee=new Bees(Double.parseDouble(str[0]),Double.parseDouble(str[1]),Double.parseDouble(str[2]));
            bees.addFirst(bee);
        } catch (Exception e){
        }
    }
    public void getMaxMin() {
        double minlat = (double) Collections.min(a);
        double maxlat = (double) Collections.max(a);

        double minlon = (double) Collections.min(b);
        double maxlon = (double) Collections.max(b);

        double minalt = (double) Collections.min(c);
        double maxalt = (double) Collections.max(c);

        ArrayList<Double> mins = new ArrayList();
        mins.add(minlat);
        mins.add(minlon);
        mins.add(minalt);
        double midD = (minlat - maxlat);
        double midW = (maxlon - minlon);
        double midH = (maxalt - minalt);
        double diagonal = Math.sqrt(Math.pow((midD)*111325, 2) + Math.pow((midW)*111325, 2)+Math.pow((midH),2));
        //double diagonal = Math.sqrt(Math.pow(ph, 2) + Math.pow((midH), 2));
        if (diagonal > 100) {
            Octree octree = new Octree();
            System.out.println("empty");
            octree.octree(bees, mins, midD, midW, midH);
        } else {
            crash();
        }
    }
    public void crash() {
        System.out.println("Bees at the following coordinates are in danger of colliding");
        for (int i = 0; i < bees.size(); ++i) {
            System.out.println(a.poll() + "," + b.poll() + "," + c.poll());
        }
    }
}
