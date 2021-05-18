public class Lc55_JumpGame_M {

    //jumpgame
    public static  boolean canJump(int[] nums) {
        int len=nums.length;
        if (len==1) return  true;
        int tempReach=nums[0];
        int maxReach=nums[0];



        for(int i=0; i< len; i++){

            if (nums[i] + i > tempReach) tempReach=nums[i] + i;

            if(i==maxReach) {

                maxReach=tempReach;

            }

            if (maxReach >= len-1) return true;


        }
        return false;

    }
}
