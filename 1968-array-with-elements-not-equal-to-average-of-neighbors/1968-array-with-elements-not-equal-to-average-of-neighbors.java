class Solution {

    public int[] rearrangeArray(int[] nums) {
        //We want to sort the number then alternate between a smallest
        //number and biggest number to grantee that they will never be averaged.
        Arrays.sort(nums);
        int l=0, r=nums.length-1, len=nums.length;
        int[] res = new int[len];
        for(int i=0; i<len; i++) {
            //move left and increment counter to next index for right
            res[i++] = nums[l];
            l++;
            // only move right if less then left
            if(l<=r) {
                res[i] = nums[r];
                r--;
            }
        }
        return res;
    }
    
}