class Solution {
    public int countSquares(int[][] matrix) {
 
        int rows=matrix.length; 
        int cols=matrix[0].length; 
        int sum=0; 
        
    int[][] dp= new int[rows][cols];
        
        // populate first row
        
        for (int i=0; i < cols; i++){
            
            int curr=matrix[0][i]; 
            sum+=curr; 
            dp[0][i]=curr; 
            
        }
        // populate first col
        for (int i=1; i < rows; i++){
            int curr=matrix[i][0]; 
            sum+= curr; 
            dp[i][0]=curr; 
            
        }
        
        for(int i=1; i < rows; i++){
            
            for (int j=1; j < cols; j++) {
                
                int curr= matrix[i][j]; 
                
                if (curr==1){
                    
                    // min of of the above value, left, and diagonal
                    dp[i][j]=curr + Math.min(Math.min(dp[i-1][j],dp[i][j-1]), dp[i-1][j-1]); 
                    
                    sum+=dp[i][j]; 
                }
                
            }
        }
        
        
        return sum; 
        
        
        

    }
}