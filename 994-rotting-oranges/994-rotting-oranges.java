class Solution {
    public int orangesRotting(int[][] grid) {
        
          if(grid == null || grid.length == 0) return 0;
        
        Deque<int[]> q=new ArrayDeque<>();
        int rows=grid.length; 
        int cols=grid[0].length; 
        
        int fresh=0; 
        int minutes=0; 
        
        for (int i=0; i < rows;i++){
            
            for (int j=0; j < cols; j++){
                
                if (grid[i][j]==1) fresh++; 
                else if (grid[i][j]==2) q.offer(new int[]{i, j}); 
            }

        }
        
         if(fresh==0) return 0; 
        
        int[][] directions={{0,1},{0,-1},{1,0}, {-1,0}};
        
       while(!q.isEmpty()){
           
           int n=q.size(); 
           
           for (int i=0; i < n; i++){
               
               int[] curr=q.poll();
               
               int y=curr[0]; 
               int x=curr[1]; 
               
               for (int[] d: directions){
                   
                   int newRow=y + d[0]; 
                   int newCol=x + d[1]; 
                   
                   if (newRow > rows-1 || newRow < 0 || newCol > cols-1 || newCol < 0 ) continue; 
                   if (grid[newRow][newCol]==2 || grid[newRow][newCol]==0) continue; 
                   grid[newRow][newCol]=2; 
                   fresh--;
                   q.offer(new int[]{newRow, newCol}); 
                   
               }
               
           }
          minutes++;
        
           
           
       }
   
    return fresh==0 ? minutes-1 : -1; 
         
        
    }
}