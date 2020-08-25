/**
 * CodingBat2 Recursion2  
 * 
 * @author Maria Paulina Ocampo,Maria Jose Gutierrez
 */
public class CodingBat2{
 public boolean groupSum6(int start, int[] nums, int target) {
        if (start >= nums.length) 
        return target == 0;                                     
        if (groupSum6(start + 1, nums, target - nums[start]))
        return true;                                           
        if (nums[start] == 6)
        target -= 6;                                           
        return groupSum6(start + 1, nums, target);             
    }
public boolean groupNoAdj(int start, int[] nums, int target) {
     if (start >= nums.length)
        return (target == 0);
     if (groupNoAdj(start+1, nums, target)) 
        return true;
     if (groupNoAdj(start+2, nums, target-nums[start]))
       return true; 
     return false;
}
public boolean groupSum5(int start, int[] nums, int target) {
     if(start==nums.length)
       return target==0;
     if(nums[start] % 5 == 0){
       if(start<nums.length-1 && nums[start+1]==1) 
         return groupSum5(start+2,nums,target-nums[start]);
     else
           return groupSum5(start+1,nums,target-nums[start]);
      }
      return groupSum5(start+1,nums,target-nums[start])
       ||groupSum5(start+1,nums,target);
}
public boolean splitOdd10(int[] nums) {
    return splitOdd10Aux(0, nums, 0, 0);
}
public boolean splitOdd10Aux(int start, int[] nums, int mult, int odd) {
    if(start >= nums.length)
        return mult % 10 == 0 && odd % 2 == 1;
    if(splitOdd10Aux(start+1, nums, mult + nums[start], odd))
        return true;                  
    if(splitOdd10Aux(start+1, nums, mult, odd + nums[start]))
        return true;            
    return false;
}
}