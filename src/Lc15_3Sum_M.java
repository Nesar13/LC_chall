import java.util.*;

public class Lc15_3Sum_M {

    // we sort the array first
    // we basically use three pointers, i, left and, right
    // we start i at 0 and left at 1, and right at the end
    // we change the pointers based on the sum and our target 0 since we know moving
    // to the right means we will have a greater sum and moving to the left is less
    // i is only incremented forward and we don't consider previous i's anymore
    // the tricky part is to avoid duplicate in solution like  [-4,-1,-1,0,1,2]
    public static List<List<Integer>> threeSum2(int[] num) {

        int len=num.length;
        List<List<Integer>> res = new LinkedList<>();
        if (len <3) return res;
        Arrays.sort(num);

        for (int i = 0; i < num.length-2; i++) {
            // for edge cases such as [00000]
            if (i == 0 || (i > 0 && num[i] != num[i-1])) {
                int lo = i+1, hi = num.length-1, sum = num[i]+num[lo] + num[hi];
                while (lo < hi) {
                    if (sum == 0) {
                        res.add(Arrays.asList(num[i], num[lo], num[hi]));
                        while (lo < hi && num[lo] == num[lo+1]) lo++;
                        while (lo < hi && num[hi] == num[hi-1]) hi--;
                        lo++; hi--;
                    } else if (sum<0) lo++;
                    else hi--;
                }
            }
        }
        return res;
    }
    public static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res= new ArrayList<>();
        int len=nums.length;
        if (len<3 ) return res;
        Arrays.sort(nums);



        for (int i = 0; i < len; i++) {
           int left=i+1;
           int right=len-1;
            while (left < right){

                int sum=nums[i]+nums[left]+nums[right];

                if (sum == 0) {

                    Integer[] temp= {nums[i], nums[left], nums[right]};

                    if( !duplicate(temp, res) ) {
                        res.add(Arrays.asList(temp));
                    }
                    left++;
                    right--;

                } else if(sum > 0){

                    right--;
                }
                else {

                    left++;

                }

            }
        }



        return res;
    }

    private static boolean duplicate(Integer[] temp, List<List<Integer>> res) {
        for (List<Integer> re : res) {
            if (((temp[0].equals(re.get(0))) && (temp[1].equals(re.get(1))) && (temp[2].equals(re.get(2))))) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
//[-1,0,1,2,-1,-4]
        int  [] arr={-1,0,1,2,-1,-4};
        int  [] arr2={0,0,-1,2,-1,0};


        System.out.println(threeSum2(arr));
    }
}
