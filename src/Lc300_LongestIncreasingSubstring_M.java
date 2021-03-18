import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Lc300_LongestIncreasingSubstring_M {


    public static void main(String[] args) {

        //Input: nums = [0,1,0,3,2,3]
        // solution: 0,1,2,3
        //Output: 4

        int[] nums = {0, 1, 0, 3, 2, 3};
        System.out.println(lengthOfLIS5(nums));

    }

    // we use recursion to check if the current number is greater than prev, and we add 1 if so
    // otherwise we continue the recursive call in the next index
    public static int lengthOfLIS(int[] nums) {

        int[] dp = new int[nums.length];

        return helper(nums, Integer.MIN_VALUE, 0, dp);
    }

    public static int helper(int[] nums, int prev, int curPosition, int[] dp) {
        if (curPosition == nums.length) {
            return 0;
        }
        int taken = 0;

        if (nums[curPosition] > prev) {
            taken = 1 + helper(nums, nums[curPosition], curPosition + 1, dp);

        }
        // note we keep prev the same as it is a possible solution
        // since we will be comparing with next index to make sure the
        // the value is increasing
        int nottaken = helper(nums, prev, curPosition + 1, dp);
        return Math.max(taken, nottaken);
    }

    // using recursion and memoization, we store the results in 2d array since we will have tp keep track of prev and curr
    // we have two paths, taken and not taken, once a path is taken we have to see if there's a more optimal solution
    // by not taking it as well
    public static int lengthOfLIS3(int[] nums) {
        int[][] memo = new int[nums.length + 1][nums.length];
        for (int[] l : memo) {
            Arrays.fill(l, -1);
        }
        return lengthofLIS3(nums, -1, 0, memo);
    }

    public static int lengthofLIS3(int[] nums, int previndex, int curPosition, int[][] memo) {
        if (curPosition == nums.length) {
            return 0;
        }
        // check if we already recursed through this path
        if (memo[previndex + 1][curPosition] >= 0) {
            return memo[previndex + 1][curPosition];
        }
        int taken = 0;
        // we want to consider the first number as a solution with prevIndex < 0;
        if (previndex < 0 || nums[curPosition] > nums[previndex]) {
            taken = 1 + lengthofLIS3(nums, curPosition, curPosition + 1, memo);
        }

        int nottaken = lengthofLIS3(nums, previndex, curPosition + 1, memo);
        memo[previndex + 1][curPosition] = Math.max(taken, nottaken);
        return memo[previndex + 1][curPosition];
    }

    /* public int lengthOfLIS2(int[] nums) {
         int res = 0;
         int smallNumber = Integer.MAX_VALUE;
         int index = 0;
         List<Integer> indexArr = new ArrayList<>();

         for (int i = 0; i < nums.length; i++) {
             if (nums[i] < smallNumber) {
                 smallNumber = nums[i];
                 index = i;
             }

         }
         indexArr.add(index);


     }

     public int getNextSmallestNum(int[] nums, List<Integer> lst) {
         int l = lst.size();

        int lastStoredIndex= (l!=0) ? lst.get(lst.size()-1): 0;

             for (int i = 0; i < nums.length; i++) {
             int difference=Math.abs((nums[i]- nums[lastStoredIndex]));



     }

 }*/
    // dynamic programming we store the number of ways we can get to an index i
    // by iterating from j to i and storing the max possible paths in a variable and add one
    // to the current max value and store it into our dp array, and get the max paths so far
    public static int lengthOfLIS4(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        int[] dp = new int[nums.length];
        dp[0] = 1;
        int maxans = 1;
        for (int i = 1; i < dp.length; i++) {
            int maxval = 0;
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    maxval = Math.max(maxval, dp[j]);
                }
            }
            dp[i] = maxval + 1;
            maxans = Math.max(maxans, dp[i]);
        }
        return maxans;
    }

        public static int lengthOfLIS5(int[] nums) {
            int[] dp = new int[nums.length];
            int len = 0;
            for (int num : nums) {
                int i = Arrays.binarySearch(dp, 0, len, num);
                if (i < 0) {
                    i = -(i + 1);
                }
                dp[i] = num;
                if (i == len) {
                    len++;
                }
            }
            return len;

    }
}
