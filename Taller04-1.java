/**
 * TALLER04
 * 
 * @author Maria Paulina Ocampo Duque, Maria Jose Gutierrez Estrada
 * @version 20/08/2020
 */

public class Taller04{
    public static int arrayMax(int start, int[] nums)
     {
        if(nums.length==0){
            return Integer.MIN_VALUE;
        }else if(start==nums.length){
            return nums[start-1];
        }else{
            return Math.max(nums[start], arrayMax(start+1,nums));
        }
    }

    public static void main(String[] args){
    for (int n = 50; n<= 70; n++){
        System.out.println(n);
        long ti = System.currentTimeMillis();
        arrayMax(0, new int[n]);
        long tf = System.currentTimeMillis();
        System.out.println(tf - ti);
    }
    }
  //FIBONACCI 
   public int fibonacci(int n) { //la variable n es la que determina el tamaño del problema 
  if(n<=1){
    return n;
  }else {
    return fibonacci(n-1)+fibonacci(n-2); 
  }
  }
  }

 
