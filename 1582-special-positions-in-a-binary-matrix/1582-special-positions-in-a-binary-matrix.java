class Solution {
    public int numSpecial(int[][] mat) {
        
        int rows=mat.length; 
        int cols=mat[0].length; 
    
        int[] row=new int[rows]; 
        int[] col=new int[cols]; 
        
        
        for (int i=0; i < rows; i++){
            for (int j=0; j < cols ; j++){
                if (mat[i][j]==1) {
                    row[i]++; 
                    col[j]++; 
                }
            }
        }
        
        int res=0; 
        for (int i=0; i < rows; i++){
            for (int j=0; j < cols ; j++){
                if (mat[i][j]==1 && row[i]==1 && col[j]==1) {
                     res++;
                }
            }
        }
        
        return res; 
        
    }
}