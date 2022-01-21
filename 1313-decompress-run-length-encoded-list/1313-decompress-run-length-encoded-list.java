class Solution {
    public int[] decompressRLElist(int[] nums) {
        
        int totalSize=0; 
        for (int i=0; i < nums.length; i+=2)
            totalSize+= nums[i]; 
        
        int[] res= new int[totalSize]; 
        int indx=0; 
        for (int i=0; i< nums.length; i+=2) {
            int k=nums[i]; 
            while (k-- > 0) res[indx++]=nums[i+1]; 
        }
        
       
        return res; 
    }
}