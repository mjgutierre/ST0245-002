/**
 * codingBat3 Ejercicios Array3 
 * 
 * @author Maria Paulina Ocampo,Maria Jose Gutierrez
 */

public class codingBat3 {
    public int maxSpan(int[] nums) {
        int max = 0;
        for (int i = 0; i < nums.length; i++) {
           int j = nums.length - 1;
            for (j = nums.length - 1; nums[i] != nums[j]; j--) {
                if (nums[j] == nums[i]) {
                    break;
                }
            }
            int span = j - i + 1;
            if (span > max) {
                max = span;
            }
        }
        return max;
    }
    public int[] fix34(int[] nums) {
      for (int i = 0; i < nums.length; i++)
         if (nums[i] == 3) {
            int temp = nums[i + 1];
               nums[i + 1] = 4;
          for (int j = i + 2; j < nums.length; j++)
             if (nums[j] == 4)
                 nums[j] = temp;
        }
         return nums;
    }
    public boolean canBalance(int[] nums) {
     int suma1=0;
       for (int i = 0; i < nums.length; i++){
         suma1=suma1+ nums[i];
      int suma2=0;  
      for (int j = nums.length-1; j > i; j--) {
         suma2=suma2+ nums[j];
      }
       if(suma1==suma2){
        return true;
      }
    }
      return false;
    } 
    public boolean linearIn(int[] outer, int[] inner) {
        int pos=0;                               
        for(int i=0;i<outer.length;i++){ 
          if(pos<inner.length)              
            if(outer[i]==inner[pos]){       
                pos++;                            
            }
        }
        if(pos==inner.length){                
            return true;                      
        } else { 
            return false; 
        }
    }
    public int[] seriesUp(int n) {
      int[] arr = new int[n * (n + 1) / 2];
      int cont = 0;
       for (int i=1; i<=n;i++){
         for (int j=1;j<=i;j++){
           arr[cont++]=j;
        }
      }
       return arr;
    }
}