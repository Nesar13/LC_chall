class Solution {
    public String findReplaceString(String s, int[] indices, String[] sources, String[] targets) {
        
        StringBuilder sb=new StringBuilder(); 
        

        for(int i=0; i < s.length(); i++){
            
            boolean add=true; 
            String res=""; 
            
            for (int j=0; j < indices.length; j++){
                if (indices[j]==i && indices[j]+sources[j].length() <= s.length()){
                    int sourceLength=sources[j].length();
                     res=s.substring(indices[j], indices[j]+sourceLength);
                    
                        if(res.equals(sources[j])) {
                            sb.append(targets[j]); 
                            i+=sourceLength-1; 
                            add=false; 
                    }
                }
                
            }
            
            if(add) sb.append(s.charAt(i)); 

        
            
        }
        
        
        return sb.toString(); 
    }
}