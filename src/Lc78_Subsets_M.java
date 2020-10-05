import java.util.ArrayList;
import java.util.List;

public class Lc78_Subsets_M {


    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res=new ArrayList<>();
        helper(nums, new ArrayList<Integer>(), res);

        return res;

    }

    private void helper(int[] nums, ArrayList<Integer> tempList, List<List<Integer>> res) {

        res.add(tempList);

        for (int i = 0; i <; i++) {

        }

    }


    public static void main(String[] args) {



    }
}
