class Solution {
    public int[] shuffle(int[] nums, int n) {
        int [] arr=new int[nums.length]; 
       
        
        int left=0; 
        int right=n; 
        int count=0; 
        while (right < n+n){       
            arr[count++]=nums[left++]; 
            arr[count++]=nums[right++]; 
        }
        
        return arr; 
     
}
    
}