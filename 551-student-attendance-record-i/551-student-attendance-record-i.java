class Solution {
    public boolean checkRecord(String s) {
        
        int absent=0; 
        int lateness=0; 
        int maxLate=0;
        
        
        for (int i=0; i < s.length(); i++){
            
            char c=s.charAt(i); 
            if (c=='A') {
                absent++;
                lateness=0; 
            }
            else if(c=='L') maxLate=Math.max(++lateness, maxLate); 
            else lateness=0; 
        }
        
         if (absent < 2 && maxLate < 3) return true; 
        return false; 
    }
    
   
}