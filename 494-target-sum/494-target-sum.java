class Solution {
    int total; 
    public int findTargetSumWays(int[] nums, int target) {
        
        // find sum of two arrays since we will use that as our index 
        // in 2D memo, memo[index, sum]
        total=Arrays.stream(nums).sum(); 
        
        int[][] memo=new int[nums.length][2*total+1]; 
        
        for(int[] row: memo){
            Arrays.fill(row, Integer.MIN_VALUE); 
        }
        
        return helper(nums, 0, 0, target, memo); 
        
    }
    
    int helper(int[] nums, int i, int sum, int target, int[][] memo){
        if(i==nums.length){
            return sum==target? 1: 0; 
        }
        
        if(memo[i][sum+total]!=Integer.MIN_VALUE){ 
            return memo[i][sum+total]; 
            }
        int add=helper(nums, i+1, sum+nums[i], target, memo); 
        int subtract=helper(nums, i+1, sum-nums[i], target, memo); 
        
        memo[i][sum+total]=add+subtract; 
        return memo[i][sum+total]; 
         
    }
}