class Solution {
    public String addStrings(String num1, String num2) {
        
        int num1Len=num1.length(); 
        int num2Len=num2.length();
        
        int k=Math.max(num1Len, num2Len); 
      StringBuilder sb=new StringBuilder(); 
        int dec=0; 
        int overflow=0; 
       while (dec < k){
            int val=0; 
            char c1='0'; 
             
            if (dec < num1Len){
                c1=num1.charAt(num1Len-1-dec); 
                val =c1-'0'; 
            }
            
            if (dec < num2Len){
                c1=num2.charAt(num2Len-1-dec); 
                
                val += c1-'0'; 
                
                
            }
            val+=overflow; 
            
          if( val > 9) {
              overflow=val / 10 ; 
              val=val % 10; 
 
          }  else overflow=0; 
            
             dec++;
            sb.append(""+val); 
  
            
        }
        
        if(overflow > 0) sb.append(""+overflow); 
        
        return sb.reverse().toString(); 
        
    }
}