/**
 * codingBat2 Ejercicios Array2 
 * 
 * @author Maria Paulina Ocampo,Maria Jose Gutierrez
 */

public class codingBat2{
   public int countEvens(int[] nums) {
        int count = 0;
        for (int n : nums) 
            if (n % 2 == 0) 
                count++;   
        return count;       
   }
   public int bigDiff(int[] nums) {
        int cont1=nums[0];                          
        int cont2=nums[0];                          
          for(int i=0;i<nums.length;i++){       
            if(nums[i]>=cont1)
             cont1=nums[i];                            
            if(nums[i]<=cont2)
              cont2=nums[i];                           
        }
        return cont1-cont2;                         
   }
   public boolean only14(int[] nums) {
      for(int i=0;i<nums.length;i++)
       if (nums[i] != 1 && nums[i]!= 4)
          return false;
            return true;
   }
   public int[] fizzArray3(int start, int end) {
     int[] array = new int[end - start];
      for(int i = start; i < end; i++)
        array[i - start] = i;      
       return array;
   }
   public boolean more14(int[] nums) {
      int cont1=0;
      int cont2=0;
      for(int i=0 ; i<nums.length ; i++){
        if(nums[i]==1)
          cont1++;                  
        if(nums[i]==4)
          cont2++;
      }
      if(cont1>cont2)
       return true; return false; 
   }
}