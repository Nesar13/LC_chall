class Solution {
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
                
                k += Math.ceil(piles[i]*1.0/mid);
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