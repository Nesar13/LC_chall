import java.util.ArrayList;
import java.util.List;

public class Lc54_SprialMatrix_M {

// We just have four variables for starting row, ending row, starting col, and ending col
    // where we traverse to each edge and increment and decrement edges of rectangle
    // so we set borders
    // TC: O(N) where N is the whole matrix, not nxm
    public static List<Integer> spiralOrder(int[][] matrix) {
//
        List<Integer> res= new ArrayList<>();
        int startRow=0;
        int endRow=matrix.length-1;
        int startCol=0;
        int endCol=matrix[0].length-1;

        while ( startRow <= endRow && startCol <= endCol){

            for(int i=startCol; i <= endCol; i++) res.add(matrix[startRow][i]);

            for(int i=startRow+1; i <= endRow; i++) res.add(matrix[i][endCol]);

            // note that we do not want to go back left if our rows are the same
            for(int i=endCol-1; i >= startCol; i--) {
                if (startRow==endRow) break;
                res.add(matrix[endRow][i]);
            }

            //
            for(int i=endRow-1; i > startRow; i--) {
                if (startCol==endCol) break;
                res.add(matrix[i][startCol]);
            }
            startRow++;
            endRow--;

            startCol++;
            endCol--;

        }
        return res;

    }

    public static void main(String[] args) {
        //[[1,2,3,4],[5,6,7,8],[9,10,11,12]]
        int [][] arr2= {{1,2,3,4},{5,6,7,8},{9,10,11,12}};
        int [][] arr= {{1,2,3},{4,5,6},{7,8,9}};
        System.out.println(spiralOrder(arr2));
    }
}
