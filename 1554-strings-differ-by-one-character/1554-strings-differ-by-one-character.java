class Solution {
    public boolean differByOne(String[] dict) {
        
        if (dict.length==0) return true; 
        HashSet<String> set=new HashSet(); 
        
        for (String s: dict){
            set.add(s); 
        }
        
        for (String s: dict){
            
            for(int i=0; i < s.length(); i++){
               set.remove(s); 
                for (char c='a' ; c <= 'z' ; c++){
                    StringBuilder sb=new StringBuilder();  
                    sb.append(s.substring(0, i)).append(c).append(s.substring(i+1)); 
                    if (set.contains(sb.toString())) return true; 
                }
                set.add(s); 

                
            }
            
            
        }
        
        return false; 
        
        
        
    }
}