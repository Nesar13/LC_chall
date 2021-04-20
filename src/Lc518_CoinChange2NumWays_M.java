public class Lc518_CoinChange2NumWays_M {

// we get the number of ways to generate an amount by
    // adding the previous i-coin index
    // TC: O(nd) SC: O(n)
    public static int change(int amount, int[] coins) {
        int [] dp= new int[amount+1];

        dp[0]=1;
        for (int coin: coins) {
            for( int i=1; i<= amount; i++) {

                if(coin <= i) dp[i]+=dp[i-coin];
            }}
        return dp[amount];

    }
    public static void main(String[] args) {
        int [] arr= {1,2,5};
        System.out.println(change(5,arr));
    }
}
