import java.util.HashMap;
import java.util.Map;

public class Lc532_KDiffPairsInArray_M {

    // we store the frequencies of each nums[i] in
    // HashMap iterate through all  the keys to get rid of duplicates
    // since each answer has to be unique
    // special cases for when k==0, we would havve to make sure that
    // there's more than one frequency of that element

    public static int findPairs(int[] nums, int k) {
        Map<Integer, Integer> cnt = new HashMap<>();
        for (int x : nums) {
            cnt.put(x, cnt.getOrDefault(x, 0) + 1);
        }
        int res = 0;
        for (int x : cnt.keySet()) {
            if ((k > 0 && cnt.containsKey(x + k)) || (k == 0 && cnt.get(x) > 1)) {
                res++;
            }
        }
        return res;
    }


    public static void main(String[] args) {
        //Input: nums = [3,1,4,1,5], k = 2

        int [] nums={3,1,4,1,5};
        int k=2;

        System.out.println(findPairs(nums, k));
    }
}
