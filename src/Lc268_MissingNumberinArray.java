import java.util.Arrays;

public class Lc268_MissingNumberinArray {
    public static int missingNumber(int[] nums) {

        // Ensure that n is at the last index
        if (nums[nums.length-1] != nums.length) {
            return nums.length;
        }
        // Ensure that 0 is at the first index
        else if (nums[0] != 0) {
            return 0;
        }

        Arrays.sort(nums);
        int startNum=nums[0];
        for (int i = 0; i < nums.length-1 ; i++) {
            if(nums[i] != startNum ) {
                return startNum;
            }
            startNum++;
        }
        return -1;}

    // bit manipulation
    // example input: {0,1,3,4}
    // set missing number to length
    public static int missingNumber2(int[] nums) {
        int missing = nums.length;
        for (int i = 0; i < nums.length; i++) {
            missing ^= i ^ nums[i];
        }
        return missing;
    }

    // Gauss' formula (n(n+1))/2, gives you sum of from 0 to n
    // subtract sum from actual calculated sum to find missing number;
    public int missingNumber3(int[] nums) {
        int expectedSum = nums.length*(nums.length + 1)/2;
        int actualSum = 0;
        for (int num : nums) actualSum += num;
        return expectedSum - actualSum;
    }
    public static void main(String[] args) {
        int[] nums={0,1,3,4};

        System.out.println(missingNumber2(nums));
    }
}
