import java.util.TreeMap;

public class Lc1438_LongestContinuousSubArray_M {


    // we add the values in the array with treemap as it will be sorted from least to greatest
    // and we will check if the diff of lastentry and firstentry is greater than limit
    // if so, update map and subtract the frequency, and if 0, remove the key-value
    // and move window to the right
    public static int longestSubarray(int[] nums, int limit) {

        TreeMap<Integer, Integer> map = new TreeMap<>();

        int right, left;

        for (right = 0, left = 0; right < nums.length; right++) {

            map.put(nums[right], 1 + map.getOrDefault(nums[right], 0));

            if (map.lastEntry().getKey() - map.firstEntry().getKey() > limit) {

                map.put(nums[left], map.get(nums[left])-1);
                if (map.get(nums[left])==0) map.remove(nums[left]);
                left++;

            }

        }
        return right - left  ;
    }

    public static void main(String[] args) {
        int[] arr = {4,2,2,2,4,4,2,2};

        // 4,2,2,2,4,4,2,2

        System.out.println(longestSubarray(arr, 0));
    }
}
