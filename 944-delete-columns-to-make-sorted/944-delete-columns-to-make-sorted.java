class Solution {
    public int minDeletionSize(String[] strs) {
        
        
        int res=0;
        
          
            for (int i=0; i< strs[0].length(); i++){
                for (int j=1; j < strs.length; j++){
                char curr=strs[j].charAt(i); 
                char prev=strs[j-1].charAt(i); 
                if (curr < prev){
                    res++; 
                    break;
                }
                
            }
            
        }
        
        return res; 
    }
}