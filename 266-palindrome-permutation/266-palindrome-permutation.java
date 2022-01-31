class Solution {
    public boolean canPermutePalindrome(String s) {
        
        int[] freq=new int[26];
        int odd=1; 
        
        for (int i=0; i < s.length(); i++){
            char c=s.charAt(i);
            
            freq[c-'a']++; 
            
        }
        
        
        for (int num : freq){
            if (odd < 0) return false; 
            if ( num != 0 && num  % 2==1 ) odd--; 
            
        }
        
        return true; 
    }
}