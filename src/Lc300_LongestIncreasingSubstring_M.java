import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Lc300_LongestIncreasingSubstring_M {


    public static void main(String[] args) {

        //Input: nums = [0,1,0,3,2,3]
        // solution: 0,1,2,3
        //Output: 4

        int[] nums= {0,1,0,3,2,3};
        System.out.println(lengthOfLIS3(nums));

    }

    // we use recursion to check if the current number is greater than prev, and we add 1 if so
    // otherwise we continue the recursive call in the next index
    public static int lengthOfLIS(int[] nums) {

        int [] dp=new int[nums.length];

        return helper(nums, Integer.MIN_VALUE, 0, dp);
    }

    public static int helper(int[] nums, int prev, int curPosition, int [] dp) {
        if (curPosition == nums.length) {
            return 0;
        }
        int taken = 0;

        if (nums[curPosition] > prev) {
           taken = 1 + helper(nums, nums[curPosition], curPosition + 1 ,dp);

        }
        // note we keep prev the same as it is a possible solution
        // since we will be comparing with next index to make sure the
        // the value is increasing
        int nottaken = helper(nums, prev, curPosition + 1, dp);
        return Math.max(taken, nottaken);
    }
// using recursion and memoization
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
        if (memo[previndex + 1][curPosition] >= 0) {
            return memo[previndex + 1][curPosition];
        }
        int taken = 0;
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

}
