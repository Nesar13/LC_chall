class Solution {
    public int[] diStringMatch(String S) {
        int len=S.length(); 
        int[] res=new int[len+1];
        if (len==0) return res; 
        
          
        
        int higher=len; 
        int lower=0; 
      
        for (int i =0; i < len ; i++){
            
            char c=S.charAt(i); 
            if(c=='I') res[i]=lower++; 
            else res[i]=higher--; 
        }
        
        res[len]= S.charAt(len-1) == 'D' ? lower++ : higher--; 
        
        return res; 
    }
}