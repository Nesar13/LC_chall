class Solution {
    public int numUniqueEmails(String[] emails) {
        HashSet<String> set=new HashSet(); 
        int res=0; 
        for (int i=0; i< emails.length; i++){
            String s=emails[i]; 
            StringBuilder sb=new StringBuilder(); 
            int j; 
            for (j=0; j< s.length(); j++){
                char c=s.charAt(j); 
                if(c=='@') break; 
                if(c=='.') continue; 
                if(c=='+') {
                    while(s.charAt(j) != '@') j++; 
                    break; 
                }
                sb.append(c); 
            }
            // adding the domain
            for (int k=j ; k< s.length(); k++) sb.append(s.charAt(k));
            if(!set.contains(sb.toString())){
                res++; 
                set.add(sb.toString()); 
            
            }
            
            
                
                }
                
          return res;   
            
                
            }
            
        
    
}