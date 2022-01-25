class Solution {
    public String removeOuterParentheses(String s) {
        
        int open=0; 
        
        StringBuilder sb=new StringBuilder(); 
        for (int i=0; i < s.length(); i++){
            char c=s.charAt(i); 
            
            if (c == '(' && open++ > 0) sb.append(c); 
            if (c==')' && open-- > 1) sb.append(c); 
          
          
        }
        
        return sb.toString(); 
        
    }
}