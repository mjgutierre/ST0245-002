class Taller4_2{
 public static boolean groupSum(int start, int[] nums, int target) {
     if (start == nums.length) 
      return target == 0;    
     else
      return groupSum(start+1, nums, target) || groupSum(start+1,nums,target-nums[start]);
 }
 public static void main(String[] args){
    for (int n = 20; n<=30; n++){
        long ti = System.currentTimeMillis();
        groupSum(0, new int[n], 10);
        long tf = System.currentTimeMillis();
        System.out.println(tf - ti);
    }
 }
}