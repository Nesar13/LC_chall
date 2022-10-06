class Solution {
    public String longestCommonPrefix(String[] strs) {
        
        if(strs.length==1) return strs[0]; 
        
        int j=1; 
        int res=0; 
        StringBuilder sb=new StringBuilder(); 
        
        while (j <= strs[0].length()){
            
            String first=strs[0].substring(0, j); 
            int temp=0; 
            for (int i=1; i < strs.length; i++){
                
                String curr=strs[i];
              
                if(j > curr.length()) {
                    temp=0; 
                    break; 
                }
                String sub=curr.substring(0,j);
                if(first.equals(sub)) {
                    temp=j; 
                }
                else {
                    temp=0; 
                    break; 
                }
                
            }
            if(temp > res) {
                res=Math.max(res, temp); 
                sb=new StringBuilder(); 
                sb.append(first); 
            }
            j++; 
        }
        
        return sb.toString(); 
        
    }
}