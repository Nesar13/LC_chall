class Solution {
    
 public int[][] directions={{0,1}, {0,-1}, {1,0}, {-1,0}}; 
    public int shortestPath(int[][] grid, int k) {
        
        int steps=0; 
        int gRow=grid.length, gCol=grid[0].length; 
        int[][] visited=new int[grid.length][grid[0].length]; 
        
        for(int i=0; i< gRow; i++){
            Arrays.fill(visited[i], Integer.MAX_VALUE);
            
        }
        visited[0][0]=0; 
        Queue <int[]> q=new ArrayDeque(); 
        
        
        q.offer(new int[]{0,0});
                          
        while(!q.isEmpty()){
            
            int s=q.size(); 
            
            for (int i=0; i <s; i++){
                
                int[] curr=q.poll(); 
                int row=curr[0], col=curr[1]; 
                if(row==gRow-1 && col==gCol-1) return steps; 
                for(int[] d: directions){
                    
                    int nextRow=d[0]+row, nextCol=d[1]+col; 
                    
                    if (nextRow>=0 && nextRow < gRow && nextCol>=0 && nextCol<gCol){
                        
                        int obstacle=visited[row][col]+ grid[nextRow][nextCol]; 
                        
                        if (obstacle >=visited[nextRow][nextCol] || obstacle > k) continue; 
                        
                        visited[nextRow][nextCol]=obstacle; 
                        q.offer(new int[]{nextRow, nextCol}); 
                        
   
                    }
                    
                }
               
                
                
                
            }
            
             steps++; 
            
        }
      return -1;
                         
   
    }
}