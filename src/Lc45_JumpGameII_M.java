public class Lc45_JumpGameII_M {

    public static  int jump(int[] nums) {
        int len=nums.length;
        int steps=0;
        if (len<2) return  steps;
        int tempReach=nums[0];
        int maxReach=nums[0];

        for(int i=0; i< nums.length-1; i++){

            if (nums[i] + i > tempReach) tempReach=nums[i] + i;

            if(i==maxReach) {

                steps++;

                maxReach=Math.max(tempReach, nums[i]+i);

            }

        }
        return steps+1;

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
