import java.util.Arrays;

public class Lc322_CoinChange_M {

// we use dp to store the number of coins possible to make n amount
    // we expect to require less than n amount of coins
    // TC: O(N*d) where d is the denomination and SC is O(amount)
    public static int coinChange(int[] coins, int amount) {
        int[] dp=new int[amount+1];
        Arrays.fill(dp,amount+1);
        dp[0]=0;
        for(int i=1;i<=amount;i++)
            for(int coin:coins)
                if(i>=coin) dp[i]=Math.min(dp[i],dp[i-coin]+1);
        return dp[amount]>amount?-1:dp[amount];
    }



    public static void main(String[] args) {
//Input: coins = [1,2,5], amount = 11
//Output: 3
//Explanation: 11 = 5 + 5 + 1
        int [] coins={1,2,5};
        int amount= 11;

        System.out.println(coinChange(coins, amount));

    }
}
