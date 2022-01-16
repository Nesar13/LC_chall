class Solution {
    public int mostWordsFound(String[] sentences) {
        
        
        int res=0; 
        
        for (String s : sentences){
            int temp=0; 
            for (int i=0; i < s.length(); i++){
                char c= s.charAt(i); 
                
                if (Character.isWhitespace(c)) temp++;
                
            }
            res=Math.max(res, temp+1); 
            
        }
        
        
        return res; 
    }
}