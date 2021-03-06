import java.util.HashMap;
import java.util.Map;

public class Lc128_LongestConsecutiveInteger_H {


    // we can sort and just figure out the longest sequence
    // but this solution would be O(nlogn)
    // Another solution is that we can store all the values in a hashmap
    // check if a num to the
    // right and left of the current num exists in the map and increment/decrement
    // accordingly
    // we will also denote the value to false so we don't traverse these numbers
    // twice
    // TC: O(n)  and SC: O(n)

    public static Map<Integer, Boolean> map = new HashMap<>();
    public static int res = Integer.MIN_VALUE;

    public static int longestConsecutive(int[] nums) {

        // put everything in hashtable

        for (int j : nums) {

            map.put(j, true);

        }

        for (int num : nums) {
            if (map.get(num)) {
                checkSequence(num);

            }

        }

        return res;

    }

    public static void checkSequence(int num) {
        int left = num - 1;
        int right = num + 1;
        map.put(num, false);
        while (map.containsKey(left)) {
            if (!map.get(left)) break;
            else {
                map.put(left, false);
                left--;

            }

        }

        while (map.containsKey(right)) {
            if (!map.get(right)) break;
            else {
                map.put(right, false);
                right++;
            }


        }
        res = Math.max(res, (right - 1) - (left + 1) + 1);

    }

    public static void main(String[] args) {
        //Your input
        //[100,4,200,1,3,2]
        int[] arr = {100, 4, 200, 1, 3, 2};

        System.out.println(longestConsecutive(arr));
    }
}
