class Solution {
    public String reverseWords(String s) {
        StringBuilder res=new StringBuilder(); 
        StringBuilder sb=new StringBuilder();
        
        for (int i=0; i < s.length(); i++){
            
            char c=s.charAt(i); 
            
            if (!Character.isWhitespace(c)) sb.append(c); 
            else {
                String temp= sb.reverse().toString(); 
                res.append(temp); 
                sb=new StringBuilder(); 
                while (Character.isWhitespace(s.charAt(i))) {
                    res.append(s.charAt(i));
                    i++; 
                    
                }
                i--; 
            }
            
        }
        if (sb.length() != 0 ){
             res.append(sb.reverse().toString());
        }
       
        
        return res.toString(); 
        
    }

}