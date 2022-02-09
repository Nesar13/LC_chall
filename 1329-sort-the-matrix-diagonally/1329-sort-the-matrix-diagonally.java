class Solution {
    public int[][] diagonalSort(int[][] mat) {
        
        int rows=mat.length; 
        int cols=mat[0].length; 
        
        for (int i=0; i < rows; i++){
            
            sortADiagonal(i, 0, mat); 
            
        }
        for (int j=1; j < cols; j++){
            
             sortADiagonal(0, j, mat); 
        }
        
        return mat; 
    }
    
    
    
    public void sortADiagonal(int row, int col, int[][] mat){
        int rows=mat.length; 
        int cols=mat[0].length; 
        List<Integer> diagonal= new ArrayList(); 
        int diagonalLength=Math.min(rows-row, cols-col); 
        
        for (int i=0; i < diagonalLength; i++){
            diagonal.add(mat[row+i][col+i]); 
        }
        
        diagonal=countingSort(diagonal); 
        System.out.println(diagonalLength);
        System.out.println(diagonal);
        for (int i=0; i < diagonalLength; i++){
            mat[row+i][col+i]=diagonal.get(i); 
        }
        
        
    }
    
    
    List <Integer> countingSort(List<Integer> diagonal){
        
        int len=100; 
        int[] freqArr=new int[101]; 
        
        for (int num: diagonal){
            freqArr[num]++; 
        }
        
        List<Integer> sortedNums=new ArrayList<>(); 
        for (int i=0; i < 101; i++){
            
            while ( freqArr[i]-- > 0) sortedNums.add(i);
        }
        
        return sortedNums; 
        
        
        
    }
}