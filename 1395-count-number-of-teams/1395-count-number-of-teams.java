class Solution {
    public int numTeams(int[] rating) {
        int res=0; 

        for (int i=0; i < rating.length; i++){
            int leftSmaller=0; 
            int leftLarger=0; 
            int rightSmaller=0; 
            int rightLarger=0; 

            for (int j=0; j < i; j++){
                
                if (rating[j] < rating[i])
                    leftSmaller++; 
                    
                else if(rating[j] > rating[i])
                    leftLarger++; 
            }
            
            
            for (int j=i+1; j < rating.length; j++){
                
                if (rating[j] < rating[i])
                   rightSmaller++;

                else if(rating[j] > rating[i]) 
                    rightLarger++; 
            }
            
            res += leftSmaller*rightLarger + leftLarger*rightSmaller;
            
        
        }
        
        return res; 
        
    }
}