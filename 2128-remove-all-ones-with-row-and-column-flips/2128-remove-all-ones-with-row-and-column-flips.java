class Solution {
    public boolean removeOnes(int[][] grid) {
        
        int rows=grid.length; 
        int cols=grid[0].length; 
        if (rows==1 && cols==1) return true; 
        
        HashMap <String, Integer> map=new HashMap(); 
        StringBuilder sb=new StringBuilder(); 
        for(int i=0; i < cols ; i++){
            sb.append(grid[0][i]); 

        }
        
        map.put(sb.toString(), 1); 
         StringBuilder revMat=new StringBuilder(); 
        for (int i=1; i< rows; i++){
            sb.setLength(0); 
            revMat.setLength(0); 
            for (int j=0; j< cols; j++) {
                sb.append(grid[i][j]); 
                revMat.append( grid[i][j]==0 ? "1" : "0"); 
                
            }
            String s=sb.toString(); 
            if (map.containsKey(s)){
                map.put(s, map.getOrDefault(s, 0)+1); 
            }
            else {
                String rev=revMat.toString(); 
                if (!map.containsKey(rev)) return false; 
                map.put(rev, map.getOrDefault(rev, 0)+1 );
            }
            
            
        }
        
        return true; 
        
    }
}