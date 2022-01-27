class Solution {
    public boolean repeatedSubstringPattern(String s) {
        int[] lps = new int[s.length()];
        int i = 1;
        int j=0; 
       while( i < s.length()){
            if(s.charAt(i) == s.charAt(j)) {
                lps[i] = j+1;
                i++;
                j++;
            }
            else if(j !=0 ) {
                j = lps[j-1];
            }
            else {
                i++;
            }
        }
        System.out.println(Arrays.toString(lps)); 
        
        if(lps[lps.length - 1] == 0) return false;
        
        int patternlength = s.length() - lps[lps.length - 1];
        
        if(s.length() % patternlength == 0) return true;
        
        return false;
        
        
    }
}