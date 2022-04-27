class Solution {
    
 public int[][] directions={{0,1}, {0,-1}, {1,0}, {-1,0}}; 
    public int shortestPath(int[][] grid, int k) {
        
        int rows=grid.length; 
        int cols=grid[0].length; 
        
        
        ArrayDeque<int[]> q=new ArrayDeque<>(); 
        int[][] visited=new int[rows][cols]; 
        
        for (int[] v: visited){
            Arrays.fill(v, Integer.MAX_VALUE); 
        }
        
        
        visited[0][0]=0; 
        q.offer(new int[]{0,0}); 
        int res=0; 
        
        while (!q.isEmpty()){
            
            int s=q.size(); 
            for (int i=0; i < s; i++){
                
                int[] curr=q.poll();
                int row=curr[0]; 
                int col=curr[1]; 
                if (row==rows-1 && col==cols-1) return res; 
                for (int[] dir: directions){
                    int nextRow=dir[0] + curr[0]; 
                    int nextCol=dir[1] + curr[1]; 
                    
                    if (nextRow >= 0 && nextRow < grid.length && nextCol >=0 && nextCol < cols){
                        
                        int obstacles=visited[row][col]+ grid[nextRow][nextCol]; 
                        if (obstacles > k || obstacles >= visited[nextRow][nextCol]) continue;
                        visited[nextRow][nextCol]=obstacles; 
                        q.offer(new int[]{nextRow, nextCol}); 
                        
                    }
                    
                }
                
            
            }
            
             res++;
 
        }
        
        return -1;  
    
}
}