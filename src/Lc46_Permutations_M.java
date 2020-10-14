import java.util.ArrayList;
import java.util.List;

public class Lc46_Permutations_M {

    public static List<List<Integer>> permute(int[] nums) {

        List<List<Integer>> list = new ArrayList<>();
        // Arrays.sort(nums); // not necessary
        backtrack(list, new ArrayList<>(), nums);

        return list;

    }

    private static void backtrack(List<List<Integer>> list, List<Integer> tempList, int [] nums){
        if(tempList.size() == nums.length){
            list.add(new ArrayList<>(tempList));
        } else{
            for(int i = 0; i < nums.length; i++){
                if(tempList.contains(nums[i])) continue; // element already exists, skip
                tempList.add(nums[i]);
                System.out.println("first: " + tempList);
                backtrack(list, tempList, nums);
                tempList.remove(tempList.size() - 1);
                System.out.println("second: " + tempList);
            }
        }
    }

    public static List<List<Integer>> permute2(int[] nums) {
        List<List<Integer>> mainList=new ArrayList<>();
        helper2(nums, mainList, new ArrayList<Integer>());

        return mainList;

    }

    public static void helper2 (int [] nums,   List<List<Integer>> mainList, List<Integer> tempList) {
        if (tempList.size()==nums.length) {
            mainList.add(new ArrayList<>(tempList));
        }

        else {
            for (int i = 0; i <nums.length ; i++) {
                if(tempList.contains(nums[i])) continue;
                tempList.add(nums[i]);

                helper2(nums, mainList, tempList);

                tempList.remove(tempList.size()-1);
            }


        }


    }


    public static void main(String[] args) {


        int[] nums= {1,2,3,4};
        System.out.println(permute2(nums));


    }

}
