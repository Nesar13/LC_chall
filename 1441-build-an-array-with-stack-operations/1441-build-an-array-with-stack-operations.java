class Solution {
    public List<String> buildArray(int[] target, int n) {
    
        List<String> res=new ArrayList(); 
        
        int count=1; 
        int i=0; 
        while (i < target.length && count <= n ){
            
            if (target[i]==count) {
                res.add("Push"); 
                i++; 
               
                
            }
          else {
              res.add("Push"); 
              res.add("Pop");
          }
            count++; 
            
            
        }
        
        return res; 
        
    }
}