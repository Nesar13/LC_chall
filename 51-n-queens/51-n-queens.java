class Solution {
    
    int N; 
    public List<List<String>> solveNQueens(int n) {
        N=n; 
        List<List<String>> res=new ArrayList<>(); 
        char[][] board=new char[n][n]; 
        
        for (int i=0; i < n; i++){
            for (int j=0; j < n; j++){
                board[i][j]='.'; 
            }
        }
        
        backtrack(0, res,board,  new HashSet<>(), new HashSet<>(), new HashSet<>() ); 
        return res; 
    }
    
    List<String> createBoard(char[][] board){
        
        List<String> temp=new ArrayList<>(); 
        for(int row=0; row<board[0].length; row++){
            String currRow=new String(board[row]);
            temp.add(currRow); 
        }
        return temp; 
    }
    
    
    void backtrack(int row, List<List<String>> res, char[][] board, Set<Integer> cols, Set<Integer> diag, Set<Integer> antiDiag){
        
        if(row==N){
            res.add(createBoard(board)); // return a list<String> of board
        }
        
        for (int col=0; col < N; col++){
            
            int currDiag=row-col; 
            int currAntiDiag=row+col; 
            
            if(cols.contains(col) || diag.contains(currDiag) || antiDiag.contains(currAntiDiag)) continue; 
            
            cols.add(col); 
            diag.add(currDiag); 
            antiDiag.add(currAntiDiag); 
            board[row][col]='Q'; 
            backtrack(row+1, res,board, cols, diag, antiDiag);
            
            cols.remove(col); 
            diag.remove(currDiag);
            antiDiag.remove(currAntiDiag); 
            board[row][col]='.'; 
            
        }
        
        return; 
        
    }
    
    
}