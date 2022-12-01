class Solution {
    public int strStr(String haystack, String needle) {
        
        int[] pattern= buildPattern(needle); 
        return match(haystack, needle, pattern); 
        
    }
    
    
    int[] buildPattern(String needle){
        int[] pattern=new int[needle.length()]; 
        Arrays.fill(pattern, -1); 
        int j=0; 
        int i=1; 
        while(i < needle.length()){
            
            if(needle.charAt(i) == needle.charAt(j)){
                pattern[i]=j; 
                i++; 
                j++; 
            }
            else if(j>0) {
                j=pattern[j-1] + 1; 
            }
            else{
                i++; 
            }
            
        }
        
        return pattern; 
    }
    
    int match(String haystack, String needle, int[] pattern){
        int i=0; 
        int j=0; 
        while(i < haystack.length() && j < needle.length()){
            
            if(haystack.charAt(i) == needle.charAt(j)){
                i++; j++; 
            } else if(j > 0){ 
                j=pattern[j-1]+1; 
            } else {
                i++; 
            }
            
        }
        
        return j==needle.length() ? i-j : -1; 
    }
    
    
    
    
    
}