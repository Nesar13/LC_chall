import java.util.ArrayList;
import java.util.Arrays;

public class Lc279_PerfectSquares_M {

    public static int numSquares(int n) {
        int[] dp = new int[n+1];

        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;

        for(int i=1; i<=n; i++){

            for(int j=1; j<=Math.sqrt(i); j++){
                int c=i-(j*j);
                dp[i] = Math.min(dp[i], (dp[i-(j*j)]+1));
            }
        }

        return dp[n];
    }


    public static void main(String[] args) {

//        System.out.println(isPerfectSquare(0, 25));

        System.out.println(numSquares(13));
        //Example 1:
        //Input: n = 12
        //Output: 3
        //Explanation: 12 = 4 + 4 + 4.

        //Example 2:
        //Input: n = 13
        //Output: 2
        //Explanation: 13 = 4 + 9
        //Constraints:

        //1 <= n <= 104

    }
}
