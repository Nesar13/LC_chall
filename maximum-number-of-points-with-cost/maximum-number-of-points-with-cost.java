class Solution {
    
    public long maxPoints(int[][] points) {
        int m = points[0].length;
        long[] dp = new long[m];
        for (int[] point : points) {
            // adding points to current dp
            for (int j = 0; j < m; j++) {
                dp[j] += point[j];
            }
            // computing left side 
            for (int j = 1; j < m; j++) {
                dp[j] = Math.max(dp[j], dp[j - 1] - 1);
            }
            // computing right side 
            for (int j = m - 2; j >= 0; j--) {
                dp[j] = Math.max(dp[j], dp[j + 1] - 1);
            }
        }
        long res = 0;
        for (long e : dp) {
            res = Math.max(res, e);
        }
        return res;
    }
    
  
}