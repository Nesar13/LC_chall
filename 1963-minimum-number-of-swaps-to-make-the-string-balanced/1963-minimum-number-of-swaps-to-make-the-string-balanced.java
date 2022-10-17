class Solution {
    public int minSwaps(String s) {
        
        int open=0; 
        int res=0; 
        
        for (char c: s.toCharArray()){
            
            if (c=='[') open++; 
            else if(c==']'){
                open--; 
                if(open < 0) {
                    res++;
                    open=1; // "][" it will be -1, so we will need to swap, so instead of subtracting we will need to add 1 to the open variable, so technically it's +2
                }
            }
        }
        
      
        return res; 
        
        
        
    }
}