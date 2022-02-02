class Solution {
    public String[] findOcurrences(String text, String first, String second) {
        
        String[] arr=text.split("\\s+"); 
        List<String> res=new ArrayList(); 
        for (int i=0; i < arr.length-2; i++){
            
            String s =arr[i]; 
            if (s.equals(first) && arr[i+1].equals(second)){
                
                res.add(arr[i+2]); 
             
            }
                
            
            
            
        }
        
        
        return res.toArray(new String[res.size()]); 
        
        
    }
}