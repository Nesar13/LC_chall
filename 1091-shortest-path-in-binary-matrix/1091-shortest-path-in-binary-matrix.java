class Solution {
    int res=Integer.MAX_VALUE; 
    public int shortestPathBinaryMatrix(int[][] grid) {
        // directions (including diagonal)
        if(grid[0][0]==1 || grid[grid.length - 1][grid[0].length - 1] != 0) return -1;
        int[][] directions={{1,0}, {1,-1},{1,1}, {0, 1}, {0, -1}, {-1, 0}, {-1, -1}, {-1, 1}}; 
        
        int[][] visited=new int[grid.length][grid[0].length]; 
        
        int rows=grid.length; 
        int cols=grid[0].length; 
        Deque<int[]> q=new ArrayDeque<>(); 
        
        visited[0][0]=1;
        
        q.offer(new int[]{0, 0}); 
        
        while(!q.isEmpty()){
            
            int n=q.size(); 
            for (int i=0; i < n; i++){
                
                int[] curr=q.poll(); 
                
                int row=curr[0]; 
                int col=curr[1]; 
                if(row == rows-1 && col==cols-1) return visited[row][col]; 
                for (int[] d: directions){
                    
                    int x=d[0]+ row; 
                    int y=d[1]+ col; 
                    
                    if(x < 0 || x> rows-1 || y < 0 || y> cols-1 || grid[x][y]==1) continue; 
                    if(visited[x][y] !=0) continue; 
                    if(x == rows-1 && y==cols-1) return visited[row][col] +1; 
                    
                    visited[x][y]= visited[row][col] +1; 
                    
                    q.offer(new int[]{x, y}); 
                    
                    
                }
                
                //System.out.println(Arrays.deepToString(visited)); 
                
            }
            
            
        }
        
        return -1; 
       
        
        
    }
    

    
    
}