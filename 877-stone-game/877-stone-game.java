class Solution {
    public boolean stoneGame(int[] piles) {
      
        int n=piles.length; 
        int [][] dp= new int[n][n]; 
        
        helper(dp, piles, 0, n-1); 
        int sum=0; 
        for (int i: piles){
            sum+=i; 
        }
        
        return dp[0][n-1] > sum/2; 
        
    }
    
    int helper(int [][] dp, int[] piles, int i, int j){
        
        if (i > j) return 0; 
        
        if (dp[i][j] > 0) return dp[i][j]; 
        
        //boolean even= j-i+1 % 2 == 0 ? true : 0; 
        int left= (j-i+1) % 2 == 0 ? piles[i] : 0; 
        int right=(j-i+1) % 2 == 0 ? piles[j] : 0; 
        
        int l=helper(dp, piles, i+1, j) + left;     
        int r=helper(dp, piles, i, j-1) + right; 
            
   
        
        
        
       
        dp[i][j]= Math.max(l, r); 
        
        
        return dp[i][j]; 
        
        
        
        
    }
}