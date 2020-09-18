import static java.lang.Math.rint;

public class Lc198_HouseRobber {
    public static int rob(int[] nums) {

        if (nums.length==0) return 0;
        if (nums.length==1) return nums[0];

        // create a new array to store the sum
        int[] dp=new int[nums.length];
        // initialize the first and second value of new array
        dp[0]=nums[0];
        //store the max value between the first and second index
        dp[1]=Math.max(nums[1],nums[0]);


        for (int i = 2; i < nums.length ; i++) {

            // since we are only interested in every other house
            // we get the max of the sum of every other house
            // and the previous value in the new array
            dp[i]=Math.max(nums[i] +dp[i-2], dp[i-1]);
            
        }

        return dp[dp.length-1];
    }

    
    public static void main(String[] args) {

        int[] nums3 = {2,1,1,2};

        System.out.println(rob(nums3));
        System.out.println(rint(4.5));
    }
}
