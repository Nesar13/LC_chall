public class Lc45_JumpGameII_M {

    // we can do this problem using dp but it's O(n^2)
    // we just take note of the maxindex we can reach before having to jump
    // which means storing a temp variable so we can update our
    // maxReach once we reached maxReach
    // TC: O(n)
    public static  int jump(int[] nums) {
        int len=nums.length;
        int jumps=0;
        if (len<2) return  0;
        int tempReach=nums[0];
        int maxReach=nums[0];

        // note that we end before the last index since we want to add to our
        // jumps if we end prematurely like [2,1]
        for(int i=1; i< len-1; i++){

            if (nums[i] + i > tempReach) tempReach=nums[i] + i;

            if(i==maxReach) {

                jumps++;

                maxReach=tempReach;

            }

        }
        return jumps+1;

    }


    public static void main(String[] args) {
        //Your input
        //[2,3,1,1,4]
        //Output
        //2
        //Expected
        //2


        int [] arr= {2,3,1,1,4};

        System.out.println(jump(arr));
    }
}
