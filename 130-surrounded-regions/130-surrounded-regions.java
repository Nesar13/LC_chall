class Solution {
    public void solve(char[][] board) {
        
        int rows=board.length; 
        int cols=board[0].length;
        if (rows==0) return; 
        
        // check first row and col
        
        for (int j=0; j< cols; j++){
            dfs(board, 0, j ); 
            dfs(board, rows-1, j); 
        }
        
        for (int i=0; i<rows; i++){
            dfs(board, i, 0 ); 
            dfs(board, i, cols-1); 
        }
        
        
        for (int i=0; i < rows; i++){
            
            for (int j=0; j < cols; j++){
                
                if(board[i][j]=='O') board[i][j]='X'; 
                if(board[i][j]=='S') board[i][j]='O'; 
            }
        }
        
        
       

}
    
    void dfs(char[][] board, int i, int j){
        
        if (i < 0 || i> board.length-1 || j < 0 || j > board[0].length-1 || board[i][j]=='X'  || board[i][j]=='S') return; 
        
        if(board[i][j]== 'O') board[i][j]='S'; //s for safe Os
        
        dfs(board, i+1, j); 
        dfs(board, i-1, j); 
        dfs(board, i, j-1); 
        dfs(board, i, j+1); 
        
        
        
        
    }
    
}