public class Lc518_CoinChange2NumWays_M {

    // we create dp of size n, we get the number of ways to generate an amount by
    // adding the previous i-coin index and storing it using dp
    // we basically check for each coin, how many ways can we make the nums up to n
    // (e.g. if i=3 and coin is 2,
    //    // we know that at dp[3-1]=1 so we can add 2 to 1 have a total of 3 to include coin 2)
    // TC: O(nd) SC: O(n)
    public static int change(int amount, int[] coins) {
        int [] dp= new int[amount+1];
        dp[0]=1;
        for (int coin: coins) {
            for( int i=1; i<= amount; i++) {

                if(coin <= i)
                    dp[i]+=dp[i-coin];
            }}
        return dp[amount];
    }
    public static void main(String[] args) {
        int [] arr= {1,2,5};
        System.out.println(change(5,arr));

    }
}
