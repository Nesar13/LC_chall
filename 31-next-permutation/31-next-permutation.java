public class Solution {

    public void nextPermutation(int[] nums) {
        int len=nums.length; 
        
        if (len < 2 ) return; 
        int i=len-2; 
        // find the number that is less than previous value [1,5,1] we would arrive at index 0
        while (i >= 0 && nums[i] >= nums[i+1]){
            i--; 
        }
        
        if (i >= 0){
            int j=len-1; 
            while (j > i && nums[j] <= nums[i]) j--; 
            
            swap(nums, i, j); 
         
        }
        
           reverse(nums, i+1); 

    }
    
    
    void reverse(int[] nums, int start){
        
        int i=start; 
        int j=nums.length-1; 
        
        while (i< j){
            swap(nums, i, j); 
            j--; 
            i++; 
        }
    }
    
    void swap(int[] nums, int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;

    }
}



