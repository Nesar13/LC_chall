class Solution {
    
    // we can do freq arr or maybe hashmap
    public int maxLengthBetweenEqualCharacters(String s) {
        
        
        int len=s.length(); 
        if(len==0) return -1; 
        int[] arr=new int[26]; 
        Arrays.fill(arr, -1); 
        for(int i=0; i < len; i++){
            arr[s.charAt(i)- 'a']=i; 
        }
        int res=-1; 
        
        for (int i=0; i < len; i++){
            char c= s.charAt(i); 
            
           
            if(arr[c-'a'] != i && arr[c-'a'] != -1){
                
                res=Math.max(res, arr[c-'a'] - i-1); 
                
            }
            
            
        }
        
        return res; 
        
        
        
    }
}