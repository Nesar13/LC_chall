class Solution {
    public int maxIncreaseKeepingSkyline(int[][] grid) {
        int r=grid.length;
        int c=grid[0].length; 
        
        int res=0; 
        int[] rows= new int[r]; 
        int[] cols=new int[c]; 
        
        for (int i=0; i< r; i++){
            
            for (int j=0; j < c; j++){
                
                int curr=grid[i][j]; 

                if (curr > rows[i]) rows[i]=curr; 
                if (curr > cols[j]) cols[j]=curr; 
                
            }
        }
        
        
       for (int i=0; i< r; i++){
            
            for (int j=0; j < c; j++){
                
                int curr=grid[i][j]; 
                
                int minNum=Math.min(rows[i], cols[j]); 
                res += (minNum-curr); 
                
                
        
            }
    }
        
        return res; 
        
        
}
}