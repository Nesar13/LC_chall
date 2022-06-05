class Solution {
    public int[] searchRange(int[] nums, int target) {
        
        int left=0; 
        int right=nums.length-1; 
        int[] res=new int[2];
        Arrays.fill(res, -1); 
        
        //look for left side index
        while (left <= right){
            int mid=left + (right-left)/2; 
            if(nums[mid]==target) {
                if(mid-1 >= 0 && nums[mid-1]==target){
                    right=mid-1; 
                }else{
                    res[0]=mid;
                    break; 
                }
               
            }
            else if(nums[mid] < target) left=mid+1; 
            else right=mid-1; 
            
            
        }
        left=0; right=nums.length-1; 
        // look for right side index
        while(left <= right){
            int mid=left + (right-left)/2; 
            if(nums[mid]==target) {
                
                 if(mid+1 < nums.length && nums[mid+1]==target){
                    left=mid+1; 
                }else{
                    res[1]=mid;
                     break; 
                }
                
            }
            else if(nums[mid] <= target) left=mid+1; 
            else right=mid-1; 
            
        }
        
        
        
        return res; 
        
    }
}