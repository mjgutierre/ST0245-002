
/**
 * Taller05
 * 
 * @author Maria Paulina Ocampo,Maria Jose Gutierrez
 */

class Taller5{
  public static int suma(int[] a){
     int cont = 0;  
     for (int i = 0; i < a.length; i++) 
        cont = cont + a[i];             
     return cont; 
  }                  
  public static void main(String[] args){
      for (int n = 10000000; n < 100000020; n = n + 10000000){ 
        long ti = System.currentTimeMillis();
        suma(new int[n]);
        long tf = System.currentTimeMillis();
        System.out.println(tf-ti);      
      }
    }
}