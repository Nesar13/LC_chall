class Solution {
    public boolean canPartition(int[] nums) {
        
        int n=nums.length; 
        if (n==0) return false; 
        
        int subset=0; 
        for (int num: nums){
            subset+= num; 
        }
        if(subset % 2==1) return false; 
        int target=subset/2; 
        
        
        Boolean[][] memo=new Boolean[n+1][target+1];
        
        return helper(0, target, nums, memo); 
        
        
    }
    
    
    
    boolean helper(int index, int target, int[] nums, Boolean[][] memo){
        
        if(target==0) return true; 
        if (index > nums.length-1 || target < 0) return false;
       
        //if(index==nums.length-1 && target-nums[index] != 0) return false;
        if(memo[index][target] !=null) return memo[index][target]; 
        //if(index==nums.length-1 && target-nums[index] == 0) return true; 
         
        memo[index][target]=helper(index+1, target-nums[index], nums, memo) || helper(index+1, target, nums, memo); 
        
        return memo[index][target];
        
        
        
    }
}