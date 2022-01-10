class Solution {
//     //"hijzgaovndkjiiuwjtcpdpbkrfsi"
//        public String removeOccurrences(String s, String part) {
        
//         int len=s.length(); 
//         int plen=part.length(); 
//         if (plen > len) return s; 
        
//         boolean moreWork=true; 
        
       
//         StringBuilder sb=new StringBuilder(s); 
//         StringBuilder newSb=new StringBuilder(); 
//         while(moreWork){
            
//             moreWork=false; 
            
//             int S= sb.length(); 
//             int count=0; 
//             StringBuilder temp=new StringBuilder(); 
//             newSb=new StringBuilder(); 
            
            
//             // sb: da
//             // temp: abc
//             for(int i=0; i < S; i++){
                
//                 char c=sb.charAt(i); 
                
//                 char p=part.charAt(count); 
//                 if (c != p) {
//                     if (temp.length() != 0 ) 
//                         newSb.append(temp); 
                    
//                     temp=new StringBuilder(); 
//                     count=0; 
//                     if (c==part.charAt(count)) {
//                         temp.append(c); 
//                         count++; 
//                     }
//                     else  newSb.append(c);
//                 }
//                 if (c==p){
//                     temp.append(c); 
//                     count++;  
//                 }
                
//                 if(count==plen) {
//                      moreWork=true; 
//                     temp=new StringBuilder(); 
//                     count=0; 
//                  }
                
                   
//             }
            
//             if (temp.length() != 0) newSb.append(temp);
//             sb=new StringBuilder(newSb); 
            
            
            
//         }
        
//         return sb.toString(); 
        
//     }
    
      public String removeOccurrences(String s, String p) {
        return s.contains(p) ? removeOccurrences(s.replaceFirst(p, ""), p) : s;
    }
}