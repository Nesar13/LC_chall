class Solution {
    
    
    public boolean checkValidString(String s) {
        
        int leftMin=0; 
        int leftMax=0; 
        
        for (int i=0; i < s.length(); i++){
            
            char c=s.charAt(i); 
            if (c=='(') {
                // we don't have much choices but increment both
                leftMin++; 
                leftMax++; 
            }
            else if(c==')'){
                leftMin--; 
                leftMax--; 
            }
            else {
                // we have an asterisk
                leftMin--; 
                leftMax++;          
            }
            if(leftMin < 0) leftMin=0; // (*)() for this case where we can have negative leftMin
            if(leftMax < 0) return false; 
        }
        
       
        return leftMin==0; 
        
    }
}