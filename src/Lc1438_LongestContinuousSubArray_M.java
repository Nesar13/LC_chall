public class Lc1438_LongestContinuousSubArray_M {
    //TODO:
    public static int longestSubarray(int[] nums, int limit) {
        int res = Integer.MIN_VALUE;
        int maxInWindow=0;

        for (int right = 0, left = 0; right < nums.length; right++) {
           int difference= Math.abs(nums[left] - nums[right]);

            maxInWindow=Math.max(maxInWindow, nums[right]);
            int maxDifference = Math.abs(nums[left] - maxInWindow);


            if (difference <= limit && maxDifference <=limit) {

                res = Math.max(res, right - left+1);
            }
            if (difference > limit || maxDifference > limit) {
                left++;

            }


        }

        return res;
    }

    public static void main(String[] args) {
        int[] arr = {4,2,2,2,4,4,2,2};

        // 4,2,2,2,4,4,2,2

        System.out.println(longestSubarray(arr, 0));
    }
}
