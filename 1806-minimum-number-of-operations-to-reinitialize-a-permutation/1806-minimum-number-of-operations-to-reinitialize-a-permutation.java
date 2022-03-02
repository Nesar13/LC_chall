class Solution {
    public int reinitializePermutation(int n) {
    int res=0;
    int i=1;
        while (res==0 || i > 1){
            if (i % 2 == 0) i=i/2; 
            else 
                i= n/2 + (i-1)/ 2; 
            res++; 
            
        }
        
        return res;
    }
}