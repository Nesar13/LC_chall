class Solution {
    public int minProductSum(int[] nums1, int[] nums2) {
        
        Arrays.sort(nums1); 
        Arrays.sort(nums2); 
        
        int left=0; 
        int right=nums2.length-1; 
        int sum=0; 
        
        while (left < nums1.length){
            
            sum += nums1[left++] * nums2[right--]; 
            
        }
        
        return sum; 
        
    }
}