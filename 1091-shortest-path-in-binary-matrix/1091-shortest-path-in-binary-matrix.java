class Solution {
    public int shortestPathBinaryMatrix(int[][] grid) {
        
        int rows=grid.length; 
        int cols=grid[0].length; 
        if(rows==0) return 0; 
        if(grid[0][0]==1) return -1; 
        ArrayDeque<int[]> q=new ArrayDeque<>(); 
        int res=0; 
        boolean[][] visited=new boolean[rows][cols];
        int[][] directions={{0,1}, {0,-1}, {1,0}, {1,1}, {1,-1}, {-1, 0}, {-1, -1}, {-1, 1}}; 
        
        q.offer(new int[]{0,0}); 
        
        while(!q.isEmpty()){
            
           
            int n=q.size(); 
            
            for (int i=0; i < n; i++){
                int[] curr= q.poll(); 
                if(curr[0]==rows-1 && curr[1]==cols-1) return res+1; 
                for (int[] d: directions){
                    
                    int row=curr[0] + d[0]; 
                    int col=curr[1] + d[1]; 
                    
                    if( row < 0 || row > rows-1 || col < 0 ||   col > cols-1 || visited[row][col] || grid[row][col]==1){
                        continue; 
                    }
                    
                    q.offer(new int[] {row, col});
                    visited[row][col]=true; 
                    
                    
                    
                }
                
               
                
            }
            res++; 
            
            
        }
        
        return -1; 
        
    }
}