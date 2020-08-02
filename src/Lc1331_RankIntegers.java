import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Lc1331_RankIntegers {

    public int[] arrayRankTransform(int[] arr) {
        // Create copy array O(N) time and space
        int[] copyArr = new int[arr.length];
        for (int i = 0; i < arr.length; i++) copyArr[i] = arr[i];

        // Sort the copy array. O(nlogn) time complexity
        Arrays.sort(copyArr);

        // HashMap, key: number, value: rank
        // O(N) time to loop through. O(N) space to store all the numbers
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : copyArr) {
            if (!map.containsKey(num)) map.put(num, map.size() + 1);
        }

        // Use map to build rankings. O(N) time to loop through.
        for (int i = 0; i < arr.length; i++) arr[i] = map.get(arr[i]);

        return arr;
    }

    public static void main(String[] args) {

    }
}
