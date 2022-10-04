class Solution {
    public int lengthOfLastWord(String s) {
        
        if(s.length()==0) return 0; 
        String newWord=s.trim(); 
        int res=0; 
        for ( int i= newWord.length()-1; i>=0; i--){
            
            char c=newWord.charAt(i); 
            
            if(Character.isWhitespace(c)) break; 
            res++; 
            
        }
        
        return res; 
        
    }
}