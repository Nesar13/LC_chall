class Solution {
    
    // for this problem we can do top down recursive dp or bottom up dp
    // this is bottom up dp
    // We have to realize that 0s by itself is invalid as well as numbers like 06
    // and that we have between 
    // dp[i] represents the sum of number of ways we can decode the prev value, 
    // and the previous two values,well it reprsents the number of ways to represent 
    // the string all the way to ith index
    //O(n) time | O(n) space 
    
    public int numDecodings(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        int n = s.length();
        int[] dp = new int[n + 1];
        dp[0] = 1; // for empty string
        dp[1] = s.charAt(0) != '0' ? 1 : 0; // for first character, it's invalid if 0
        for (int i = 2; i <= n; i++) {
            int first = Integer.valueOf(s.substring(i - 1, i));// check if last value is valid
            int second = Integer.valueOf(s.substring(i - 2, i)); // check if last two value are valid
            if (first >= 1 && first <= 9) {
               dp[i] += dp[i-1];  
            }
            if (second >= 10 && second <= 26) { // two nums that are greater than 09 since it's invalid 
                dp[i] += dp[i-2];
            }
        }
        return dp[n];
    }
}