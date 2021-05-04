import java.util.*;

public class Lc18_4Sum_M {
    public Set<List<Integer>> res=new HashSet<>();
    public List<List<Integer>> fourSum(int[] nums, int target) {

        if (nums.length <4) return new ArrayList<>(res);

        Map<Integer, List<List<Integer>>> map=new HashMap<>();

        for(int i=1; i< nums.length-1; i++){

            for (int j=i+1; j< nums.length; j++){
                int sum=nums[i] + nums[j];
                int diff=target-sum;
                if(map.containsKey(diff) ){


                    appendResult(map.get(diff), nums[i], nums[j]);

                }

            }
            int count=0;

            while ( count < i) {
                int sum=nums[count]+nums[i];

                Integer [] temp= {nums[count], nums[i]};
                if (map.containsKey(sum)) {

                    map.get(sum).add(Arrays.asList(temp));


                } else {
                    List<List<Integer>> l=new ArrayList<> ();
                    l.add(Arrays.asList(temp));
                    map.put(sum, l);
                }
                count++;

            }
        }
        return new ArrayList<>(res);
    }

    private void appendResult(List<List<Integer>> temp, int firstNum, int secondNum) {

        for (int i = 0; i < temp.size(); i++) {
            Integer[] arr = {temp.get(i).get(0), temp.get(i).get(1), firstNum, secondNum};

            // need to sort to compare values in the hashset
            Arrays.sort(arr);

            res.add(Arrays.asList(arr));
        }
    }
    public static void main(String[] args) {

    }
}
