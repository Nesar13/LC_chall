class Solution {
    public List<String> generateParenthesis(int n) {
        
        List<String> res=new ArrayList<>(); 
        StringBuilder sb=new StringBuilder(); 
        backtrack(n, 0, 0, res, sb); 
        return res; 
        
    }
    
    void backtrack(int n, int open, int close, List<String> res, StringBuilder sb){
        
        if (open+close == n+n) res.add(sb.toString()); 
        
        if (open< n){
            int len=sb.length(); 
            sb.append("("); 
            backtrack(n, open+1, close, res, sb); 
            sb.setLength(len); 
            
            
        }
        
        if(close < open){
             int len=sb.length(); 
            sb.append(")"); 
            backtrack(n, open, close+1, res, sb); 
            sb.setLength(len);
        }
        
        
    }
}