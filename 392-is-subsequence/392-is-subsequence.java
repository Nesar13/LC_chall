class Solution {
    public boolean isSubsequence(String s, String t) {
        
        int n=s.length(); 
        int m=t.length(); 
        if(s.equals(t)) return true; 
        if(n==0) return true; 
        int first=0; 
        int second=0; 
        
        while (first < n && second < m) {
            char sChar=s.charAt(first); 
            char tChar=t.charAt(second); 
            
            if (sChar==tChar){
                first++; 
            }
            second++; 
            
        }
        
        if(first == n) return true; 
        
        return false; 
        
    }
}