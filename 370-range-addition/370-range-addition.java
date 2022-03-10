class Solution {
    
    
    // we can have 1, 10
    // 
    // 0 1 2 3 4 5 7
    //   2 3 2 3
    public int[] getModifiedArray(int length, int[][] updates) {
        
        int[] arr=new int[length]; 
        
        for (int[] u: updates){
            
            int start=u[0]; 
            int end=u[1]; 
            int inc=u[2]; 
            for (int i=start; i <=end ; i++){
                arr[i]+=inc; 
            }
            
            
        }
        
        
        return arr; 
        
        
        
    }
}