class Solution {
    public int findMin(int[] nums) {
        
        int left=0; 
        int right=nums.length-1; 
        int res=nums[0]; 
        
        while (left <= right){
            
            if(nums[left] < nums[right]){// we check if our section is already sorted
                res=Math.min(nums[left], res); 
                break; 
            }
            int mid=left+(right-left)/2; 
            
            res=Math.min(res, nums[mid]); 
           if(nums[mid] >= nums[left]) {
               left=mid+1; 
            }
            else right=mid-1; 
        }
        
        return res; 
    }
}