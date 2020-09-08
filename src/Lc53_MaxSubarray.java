public class Lc53_MaxSubarray {

    //100% fastest solution DP
    public static int maxSubArray(int[] nums) {
        int[] dp = new int[nums.length];
        dp[0] = nums[0];

        for (int i = 1; i < nums.length; i++)
            dp[i] = Math.max(nums[i] + dp[i - 1], nums[i]);

        int max = dp[0];

        for (int i = 1; i < nums.length; i++)
            max = Math.max(dp[i], max);
        return max;
    }


    public static void main(String[] args) {
        int [] nums= {-2,1,-3,4,-1,2,1,-5,4};

        System.out.println(maxSubArray(nums));
    }


}