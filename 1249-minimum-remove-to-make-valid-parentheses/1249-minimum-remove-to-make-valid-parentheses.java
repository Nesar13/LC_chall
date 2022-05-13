class Solution {
    // 1) we just count the number of open parentheses '(' and 
    // decrement if we encounter closing
    // parentheses, 
    // 2)  skip if we encounter a closing 
    // parentheses when open==0 (which means we have a valid parentheses 
    // so far and we don't need a closing one to start a new valid parentheses)
    // 3) then as a edge case (for cases like '()('   
    // we iterate backwards since we can have excess open parentheses
    // and add it to our new stringbuilder and reverse it 
    
    public String minRemoveToMakeValid(String s) {
      
        StringBuilder sb=new StringBuilder(); 
        int open=0; 
        // () )
        
        for (int i=0; i < s.length(); i++){
            char c=s.charAt(i); 
            if (c=='(') open++; 
            else if (c==')'){
                if (open==0) continue; 
                open--; 
            }
            
            sb.append(c); 
            
        }
        
        
        // () (
        
        StringBuilder res=new StringBuilder(); 
        
        for (int i=sb.length()-1; i >=0; i--){
            
            char c=sb.charAt(i); 
            
            if(c=='(' && open>0) {
                open--; 
                continue; 
            }
            res.append(c); 
        }
        
        
        return res.reverse().toString(); 
        
    }
}