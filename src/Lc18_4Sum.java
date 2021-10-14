import java.util.*;

public class Lc18_4Sum {


    public static List<List<Integer>> res=new ArrayList<>();
    public static List<List<Integer>> fourSum(int[] nums, int target) {


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
        return res;
    }

    private static void appendResult(List<List<Integer>> temp, int firstNum, int secondNum) {

        for (int i=0; i < temp.size(); i++){
            Integer [] arr= { temp.get(i).get(0),temp.get(i).get(1), firstNum, secondNum};

            res.add(Arrays.asList(arr));
        }

    }

    public static void main(String[] args) {
        //[1,0,-1,0,-2,2]
        //0

        int [] arr= {1,0,-1,0,-2,2};
        System.out.println(fourSum(arr, 0) );

    }
}
