class Solution {
    // hmm arr[i] >k ? 
    //      if less than : 
    //            k -= arr[i]-1
    //      if greater: 
    //          
    public int findKthPositive(int[] arr, int k) {
        // 6 k=2, 1,2,3,4,5,6
        // 6 - (6-2)
        //k=4, arr[0]=3
      
        
       
        if (arr[0]-1 >= k ) return k; 
        k -=arr[0]-1; 
        
        
        for (int i=1; i< arr.length; i++){
            
            int curr=arr[i]; 
            int prev=arr[i-1]; 
            if (curr != prev+1 ) {
                if (curr-prev-1 >= k ){
                    
                    return prev+k; 
                }
                else {
                    k=k-(curr-prev-1);
                }
                
            }
           
                
            }
        
        return arr[arr.length-1] + k; 
        }
        
            
    
}