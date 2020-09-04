public class Lc70_ClimbingStairs {

    public static int climbStairs0(int n) {
        if (n == 1) {
            return 1;
        }
        int[] dp = new int[n + 1];
        dp[1] = 1;
        dp[2] = 2;
        for (int i = 3; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }

    // brute force using recursion O(n^2)
    public static int climbStairs1(int n) {
        return climb_Stairs1(0, n);
    }

    public static int climb_Stairs1(int i, int n) {
        if (i > n) {
            return 0;
        }
        if (i == n) {
            return 1;
        }
        return climb_Stairs1(i + 1, n) + climb_Stairs1(i + 2, n);
    }


    // Using recursion + memoization
    public static int climbStairs3(int n) {
        int memo[] = new int[n + 1];
        return climb_Stairs3(0, n, memo);
    }

    public static int climb_Stairs3(int i, int n, int memo[]) {
        if (i > n) {
            return 0;
        }
        if (i == n) {
            return 1;
        }
        if (memo[i] > 0) {
            return memo[i];
        }
        memo[i] = climb_Stairs3(i + 1, n, memo) + climb_Stairs3(i + 2, n, memo);
        return memo[i];
    }



    public static void main(String[] args) {
        System.out.println(climbStairs0(5));
    }


}
