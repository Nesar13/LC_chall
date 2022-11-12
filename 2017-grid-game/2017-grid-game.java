class Solution {
    // we can do a prefix sum of the the two rows
    // 
    public long gridGame(int[][] grid) {
        //arrays.stream is just used to sum first row
        long topSum = Arrays.stream(grid[0]).asLongStream().sum(), bottomSum = 0;
        long ans = Long.MAX_VALUE;
        for (int i = 0; i < grid[0].length; ++i) {
            topSum -= grid[0][i];
            ans = Math.min(ans, Math.max(topSum, bottomSum));
            bottomSum += grid[1][i];
            
        }
        return ans;
    }
}