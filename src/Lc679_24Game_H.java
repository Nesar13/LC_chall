import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Lc679_24Game_H {

    // we have to go through every permutation
    // so we know that we have to do a backtracking solution
    // 1) we have to first convert the integer array into a doubles list
    //    since we can have an overflow if we multiply large integers
    // 2) we have to use two for loops to get two numbers from our list and
    //    then create every possible combination with math operators
    //    like a-b,b-a, a*b, a+b, a/b, b/a
    //    and store this in our auxiliary array
    // 3) we have to remove the two numbers we used from our list since we
    //    do not want to use those two combinations again
    // 4) we add from our auxiliary array next to our main list and do a recursion
    // 5) remove the end num from our recursion in typical backtracking fashion
    // 6) add back the two numbers we used in their corresponding places
    static boolean res = false;

    // we use this because if we have  2/3 + 1/3 = .999 but not quite 1 so
    // if the difference between 24 and our num is less thant .001, it will be true
    final static double eps = 0.001;

    public static boolean judgePoint24(int[] nums) {
        List<Double> arr = new ArrayList<>();
        for(int n: nums) arr.add((double) n);
        helper(arr);
        return res;
    }

    private static void helper(List<Double> arr){
        if(res) return;
        if(arr.size() == 1){
            if(Math.abs(arr.get(0) - 24.0) < eps)
                res = true;
            return;
        }
        for (int i = 0; i < arr.size(); i++) {
            for (int j = 0; j < i; j++) {
                List<Double> next = new ArrayList<>();
                Double p1 = arr.get(i), p2 = arr.get(j);
                next.addAll(Arrays.asList(p1+p2, p1-p2, p2-p1, p1*p2));
                if(Math.abs(p2) > eps)  next.add(p1/p2);
                if(Math.abs(p1) > eps)  next.add(p2/p1);

                arr.remove(i);
                arr.remove(j);
                for (Double n: next){
                    arr.add(n);
                    helper(arr);
                    arr.remove(arr.size()-1);
                }
                arr.add(j, p2);
                arr.add(i, p1);
            }
        }
    }
    public static void main(String[] args) {
        //System.out.println(judgePoint24(new int[] {4,1,8,7}));
        System.out.println(judgePoint24(new int[] {20,4,1,1}));
    }
}
