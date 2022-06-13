class Solution {
    // This is dp, and we have to ask ourselves at each dp[i]
    // is the current value plus the value 2 houses away is greater than the
    // value 1 house away
    // the tricky part is that the first and last house are connected
    // so we have to run two dp, one excluding last index(house), and one excluding the first house
    // O(n) time | O(n) space, but we can make this O(1) space without storing dp
    public int rob(int[] nums) {
         if(nums.length==0) return 0;
         if(nums.length==1) return nums[0]; 
        int maxOfIncludingFirstHouse=getDP(Arrays.copyOfRange(nums,0, nums.length-1));
        int maxOfIncludingLastHouse=getDP(Arrays.copyOfRange(nums, 1, nums.length)); 
        
        return Math.max(maxOfIncludingFirstHouse, maxOfIncludingLastHouse); 
    }
    
    
    int getDP(int[] nums){
        
        if(nums.length==0) return 0; 
        if(nums.length==1) return nums[0]; 
        int[] dp=new int[nums.length]; 
        int res=0; 
        
        dp[0]=nums[0];
        dp[1]=Math.max(nums[1], nums[0]); 
        for (int i=2; i < nums.length; i++){
            
            // if(i==nums.length-1) {
            //     dp[i]==Math.max(dp[i-2]+nums[i], dp[i-1]); 
            // }
            dp[i]=Math.max(dp[i-2]+nums[i], dp[i-1]); 
            
            res=Math.max(res, dp[i]);
        }
        
        
    // can't return res since we might not go through loop if length of
    // array is 2
        
    return dp[dp.length-1]; 
        
    }
}