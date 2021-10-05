import java.util.Arrays;

public class Lc322_CoinChange_M {

// we use dp of size n+1 to store the number of coins possible to make n amount
    // we expect to require less than n amount of coins
    // we have to ask ourselves for the current dp[i] if dp[i] is smaller than dp[i-coin]
    // i-coin indicates the last value we can add to to have n (i.e. if i=3 and coin is 2,
    // we know that at dp[3-1]=1 so we can add 2 to 1 have a total of 3)
    // TC: O(N*d) where d is the denomination and SC is O(amount)
    public static int coinChange(int[] coins, int amount) {
        int[] dp=new int[amount+1];
        Arrays.fill(dp,amount+1);
        dp[0]=0;
        for(int i=1;i<=amount;i++)
            for(int coin:coins)
                if(i>=coin)
                    dp[i]=Math.min(dp[i],dp[i-coin]+1);
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
