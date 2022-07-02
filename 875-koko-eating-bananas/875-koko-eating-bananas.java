class Solution {
    
    // 1) we know that using the max banana value will get us the least amount of hours it takes
    // but we want to return the minimun number of bananas
    // that we should eat within h hours
    // 2) we realize that instead of iterating from 1 to maxBananas, we can use binary search to find the 
    // min number of bananas that yields under h hours
    // Input: piles = [3,6,7,11], h = 8
    // Output: 4, we find the max bananas in piles which is 11
    // so we have to iterate from 1 to 11 using binary search
    // and check if this mid value yields hours less than h
    // O(nlogm) where n is length of piles and m is the max value in piles
    // O(1) space
    public int minEatingSpeed(int[] piles, int h) {
        
        int maxNum=piles[0]; 
        
        for (int i=1; i < piles.length; i++){
            
            maxNum=Math.max(maxNum, piles[i]); 
        }
        
        
        int left=1; 
        int right=maxNum;
        int res=Integer.MAX_VALUE; 
        
        while (left <= right){
            
            int mid=left+(right-left)/2; 
            int k=0; 
            
            for (int i=0; i< piles.length; i++){
                
                k += Math.ceil(piles[i]*1.0/mid); // note we have to use a double to return the ceiling
            }
         
            if(k > h) left=mid+1;
            else {
                right=mid-1; 
                res=Math.min(res, mid); 
            }
            
            
        }
        
        
        return res; 
        
    }
}