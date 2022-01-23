class Solution {
    public int[] smallerNumbersThanCurrent(int[] nums) {
        
        int[] freqArr=new int[101]; 
        
        for(int n: nums){
            
            freqArr[n]++; 
        }
        
        int count=0; 
        for (int i=0; i< 101; i++){
            if (freqArr[i] > 0){
                int temp=count; 
                count+=freqArr[i]; 
                freqArr[i]=temp; 
                
                
                
            }
            
        }
        
        int [] res=new int[nums.length]; 
        for (int i=0; i < nums.length; i++){
            res[i]=freqArr[nums[i]];             
            
        }
        
        return res; 
        
    }
}