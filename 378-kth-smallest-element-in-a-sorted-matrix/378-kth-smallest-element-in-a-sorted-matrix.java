class Solution {
    public int kthSmallest(int[][] matrix, int k) {
        
        
        int left=matrix[0][0]; 
        int right=matrix[matrix.length-1][matrix[0].length-1]; 
        
        while (left < right){
            
            int mid=left+(right-left)/2; // mid is a value, not index
            int count=0, j =matrix[0].length-1; 
            for (int i=0; i < matrix.length; i++){
                
                while(j >=0 && matrix[i][j] > mid) j--; 
                
                count +=j+1; // the number of elements lower than mid
            }
            
           if( count < k) left= mid+1;
            else right=mid; 
        }
        
        
        return left; 
        
        
        
        
    }
}