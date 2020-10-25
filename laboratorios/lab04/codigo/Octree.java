/**
 * Octree
 * @author Maria Paulina Ocampo Duque,Maria Jose Gutierrez Estrada
 * @version 25/10/2020
 */

import java.util.ArrayList;
import java.util.LinkedList;
public class Octree{
    private double midD,midW,midH;
    public void octree (LinkedList<Bees> abejas,ArrayList<Double> mins,double midD,double midW,double midH) {
        this.midD=midD;
        this.midW=midW;
        this.midH=midH;
        ArrayList<LinkedList<Bees>> octree=new ArrayList(8); //Octree
        for (int i=0;i<8;++i) {
            LinkedList<Bees> ab=new LinkedList();
            octree.add(ab);
        }
        for (int i=0;i<abejas.size();++i) {
            Bees abeja=abejas.poll();
            int sector=hashing(abeja,mins);
            octree.get(sector).addFirst(abeja);
        }
        //First hypotenuse
        double ph=Math.sqrt(Math.pow((midD)*111325,2)+Math.pow((midW)*111325,2));
        double diagonal=Math.sqrt(Math.pow(ph,2)+Math.pow((midH),2)); 
        if (diagonal>100) {
            for (int i=0;i<8;++i) {
                if (octree.get(i).size()>1) {
                    nuevoOctree(octree.get(i),mins,i);
                }
            }
        } else {
            for (int i=0;i<8;++i) {
                if (octree.get(i).size()>0) crash(octree.get(i));
            }
        }
    }
    private int hashing(Bees abeja,ArrayList<Double> mins) {
        if (abeja.getLatitude()<=mins.get(0)+midD) {
            if (abeja.getLongitude()<=mins.get(1)+midW) {
                if (abeja.getAltitude()<=mins.get(2)+midH) {
                    return 0;
                } else {
                    return 1;
                }
            } else {
                if (abeja.getAltitude()<=mins.get(2)+midH) {
                    return 2;
                } else {
                    return 3;
                }
            }
        } else {
            if (abeja.getLongitude()<=mins.get(1)+midW) {
                if (abeja.getAltitude()<=mins.get(2)+midH) {
                    return 4;
                } else {
                    return 5;
                }
            } else {
                if (abeja.getAltitude()<=mins.get(2)+midH) {
                    return 6;
                } else {
                    return 7;
                }
            }
        }
    }
    public void nuevoOctree(LinkedList<Bees> abejas,ArrayList<Double> mins,int sector) {
        if (sector==0) {
            octree(abejas,mins,midD/2,midW/2,midH/2);
        } else if (sector==1) {
            double nuevoH=mins.get(2)+midH;
            mins.remove(2);
            mins.add(2,nuevoH);
            octree(abejas,mins,midD/2,midW/2,midH/2);
        } else if (sector==2) {
            double nuevoW=mins.get(1)+midW;
            mins.remove(1);
            mins.add(1,nuevoW);
            octree(abejas,mins,midD/2,midW/2,midH/2);
        } else if (sector==3) {
            double nuevoH=mins.get(2)+midH;
            mins.remove(2);
            mins.add(2,nuevoH);
            double nuevoW=mins.get(1)+midW;
            mins.remove(1);
            mins.add(1,nuevoW);
            octree(abejas,mins,midD/2,midW/2,midH/2);
        } else if (sector==4) {
            double nuevoD=mins.get(0)+midD;
            mins.remove(0);
            mins.add(0,nuevoD);
            octree(abejas,mins,midD/2,midW/2,midH/2);
        } else if (sector==5) {
            double nuevoD=mins.get(0)+midD;
            mins.remove(0);
            mins.add(0,nuevoD);
            double nuevoH=mins.get(2)+midH;
            mins.remove(2);
            mins.add(2,nuevoH);
            octree(abejas,mins,midD/2,midW/2,midH/2);
        } else if (sector==6) {
            double nuevoD=mins.get(0)+midD;
            mins.remove(0);
            mins.add(0,nuevoD);
            double nuevoW=mins.get(1)+midW;
            mins.remove(1);
            mins.add(1,nuevoW);
            octree(abejas,mins,midD/2,midW/2,midH/2);
        } else {
            double nuevoD=mins.get(0)+midD;
            mins.remove(0);
            mins.add(0,nuevoD);
            double nuevoW=mins.get(1)+midW;
            mins.remove(1);
            mins.add(1,nuevoW);
            double nuevoH=mins.get(2)+midH;
            mins.remove(2);
            mins.add(2,nuevoH);
            octree(abejas,mins,midD/2,midW/2,midH/2);
        }
    }
    /**
     * This prints all the coordinates of the bees of the sector, if it prints them is because they are in risk of colliding.
     */
    public void crash(LinkedList<Bees> abejas) {
        //System.out.println("Las abejas en las siguientes coordenadas estan en peligro de chocarse");
        for (Bees abeja:abejas) {
            System.out.println(abejas.poll().getLatitude()+","+abejas.poll().getLongitude()+","+abejas.poll().getAltitude());
        }
    }
}