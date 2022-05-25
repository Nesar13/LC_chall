class Solution {
    public void wallsAndGates(int[][] rooms) {
        
        
        // start at each gate 
        // visited arr
        
        int rows=rooms.length; 
        int cols=rooms[0].length; 
        if(rooms==null || rows==0) return; 
        
        Deque<int[]> q=new ArrayDeque<>(); 
        int[][] directions={{0,1}, {0, -1}, {1,0}, {-1, 0}}; 
        boolean[][] visited=new boolean[rows][cols]; 
        
        for (int i=0; i < rows; i++){
            for (int j=0; j < cols; j++){
                
                if (rooms[i][j]==0) q.offer(new int[]{i, j, 0}); 
            }
            
        }
        
        while(!q.isEmpty()){
            
            int n=q.size(); 
            
            for (int i=0; i < n; i++){
                int[] curr=q.poll(); 
                
                for (int[] d: directions){
                    
                    int newRow=d[0]+ curr[0]; 
                    int newCol=d[1] + curr[1]; 
                    
                    if (newRow > rows-1 || newRow < 0 || newCol < 0 
                        || newCol > cols-1 || rooms[newRow][newCol]==-1 || rooms[newRow][newCol]==0) continue; 
                    if(visited[newRow][newCol]) continue; 
                    
                    rooms[newRow][newCol]=curr[2]+1; 
                    visited[newRow][newCol]=true; 
                    
                    q.offer(new int[]{newRow, newCol, curr[2]+1}); 
                    
                    
                    
                }
                
                
            }
            
        }
        
        
    }
}