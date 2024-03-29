class Solution {
    public int countSubstrings(String s) {
        int res=0; 
        for (int i=0; i < s.length(); i++){
            
            int left=i, right=i; 
            
            // for odd length palindromes
            while (left >=0 && right < s.length() && s.charAt(left) == s.charAt(right)){
                left--; 
                right++;
                res++; 
            }
            
            // abba
            left=i; 
            right=i+1; 
            // for even length palindromes 
            while (left >=0 && right < s.length() && s.charAt(left) == s.charAt(right)){
                left--; 
                right++; 
                res++; 
            }
            
            
            
        }
        
        return res; 
        
    }
}