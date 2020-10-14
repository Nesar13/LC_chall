import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Lc78_Subsets_M {


    public static List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res=new ArrayList<>();
        Arrays.sort(nums);
        helper(nums, new ArrayList<Integer>(), res, 0);

        return res;

    }

    private static void helper(int[] nums, ArrayList<Integer> tempList, List<List<Integer>> res, int start) {
        // note that you have to create a new ArrayList
        res.add(new ArrayList<>(tempList));

        for (int i = start; i <nums.length ; i++) {
            tempList.add(nums[i]);
            // note that i will be incremented by 1 each time so there is no duplicates
            helper(nums, tempList, res, i+1);
            tempList.remove(tempList.size()-1);

        }

        

    }


    public static void main(String[] args) {

        int[] nums= {1,2,3};

        System.out.println(subsets(nums));



    }
}
