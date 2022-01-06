class Solution {
    public int numSplits(String s) {
        
        int[] s1=new int[26], s2=new int[26];
        int res=0;
        int uniqueChar1=0, uniqueChar2=0; 
        int len=s.length(); 
        for (int i=0; i < len; i++){
            
            char c=s.charAt(i); 
            if(s1[c-'a']++ ==0) uniqueChar1++; 
        }
     
         for (int i=0; i < len; i++){
            char c=s.charAt(i);
            if (s2[c-'a']++ ==0) uniqueChar2++; 
            if(--s1[c-'a'] ==0) uniqueChar1--; 
            if(uniqueChar1==uniqueChar2) res++; 
        }
        
        
        return res; 
        
    }
}