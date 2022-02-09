class Solution {
    public List<String> generatePossibleNextMoves(String currentState) {
        
        List<String> res=new ArrayList<>(); 
        int len=currentState.length(); 
        if (len <=1) return res; 
        int left=0; 
        int right=1; 
        
        while (right < len){
            char l=currentState.charAt(left); 
            char r=currentState.charAt(right); 
            
            if(l=='+' && r=='+'){
                StringBuilder sb=new StringBuilder(); 
                sb.append(currentState.substring(0, left)).
                    append("--").append(currentState.substring(right+1,len)); 
                res.add(sb.toString()); 
                left++; 
                right++; 
                
            }
            else {
                left++; 
                right++; 
            }
            
        }
        
        return res; 
    }
}