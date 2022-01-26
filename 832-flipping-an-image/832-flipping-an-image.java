class Solution {
    public int[][] flipAndInvertImage(int[][] A) {
    
        
        int rows=A.length; 
        int cols=A[0].length;
        
        for (int i=0; i < rows; i++){
            
            int left=0;
            int right=cols-1; 
            
            while ( left <= right){
                int temp= A[i][left] == 0 ? 1 : 0; 
                
                A[i][left]= A[i][right] == 0 ? 1 : 0; 
                A[i][right]=temp; 
                left++; 
                right--; 
                
            }

        }
        
        return A; 
        
        
    }
}