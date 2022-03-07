class Solution {
    public int twoEggDrop(int n) {
        int[] dp=new int[n+1]; 
        Arrays.fill(dp, Integer.MAX_VALUE); 
        dp[0]=0; 
        for (int i=1; i <= n; i++){
            for (int j=1; j <=i; j++){
                dp[i]=Math.min(dp[i], Math.max(j, 1 + dp[i-j]));   
            }   
        }
        return dp[n]; 
        
    }
}



// 0 1 2 3 4 5
// 0 1 2  