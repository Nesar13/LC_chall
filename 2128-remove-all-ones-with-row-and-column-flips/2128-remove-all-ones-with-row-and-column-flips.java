// class Solution {
//     public boolean removeOnes(int[][] grid) {
        
//         int rows=grid.length; 
//         int cols=grid[0].length; 
//         if (rows==1 && cols==1) return true; 
        
//         HashMap <String, Integer> map=new HashMap(); 
//         StringBuilder sb=new StringBuilder(); 
//         for(int i=0; i < cols ; i++){
//             sb.append(grid[0][i]); 

//         }
        
//         map.put(sb.toString(), 1); 
//          StringBuilder revMat=new StringBuilder(); 
//         for (int i=1; i< rows; i++){
//             sb.setLength(0); 
//             revMat.setLength(0); 
//             for (int j=0; j< cols; j++) {
//                 sb.append(grid[i][j]); 
//                 revMat.append( grid[i][j]==0 ? "1" : "0"); 
                
//             }
//             String s=sb.toString(); 
//             if (map.containsKey(s)){
//                 map.put(s,1); 
//             }
//             else {
//                 String rev=revMat.toString(); 
//                 if (!map.containsKey(rev)) return false; 
//                 map.put(rev, 1 );
//             }
            
            
//         }
        
//         return true; 
        
//     }
// }

class Solution {
    public boolean removeOnes(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        
        for(int i = 0; i < n; i++) {
            if(i == 0){ // if first row
                for(int j = 0; j < m; j++) {
                    if(grid[i][j] == 0){
                        for(int k = 0; k < n; k++){
                            flip(grid, k, j);
                        }
                    }
                }
            }
            else
            {
                for(int j = 1; j < m; j++) {
                    if(grid[i][j] != grid[i][j - 1])
                        return false;
                }
            }
        }
        return true;
    }
    
    public void flip(int[][] grid, int i, int j){
        if(grid[i][j] == 0)
            grid[i][j] = 1;
        else
            grid[i][j] = 0;
    }
}