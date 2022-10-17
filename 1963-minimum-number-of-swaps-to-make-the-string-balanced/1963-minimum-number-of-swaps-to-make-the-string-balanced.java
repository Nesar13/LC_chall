class Solution {
    public int minSwaps(String s) {
        
        // open
        // s = "][]["
        // res-1=1
        
        
        //Input: s = "]]][[["
        
        // []][
        //[[][]
        
        int open=0; 
        int res=0; 
        
        for (char c: s.toCharArray()){
            
            if (c=='[') open++; 
            else if(c==']'){
                open--; 
                if(open < 0) {
                    res++;
                    open=1; 
                }
            }
        }
        
        // if(res==1) return 1; 
        // return res ==0 ? 0 : res-1; 
        return res; 
        
        
        
    }
}