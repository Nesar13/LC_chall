public class Lc240_Search2DMatrix_M {


    public static void main(String[] args) {
//Input: matrix = [[1,4,7,11,15],
// [2,5,8,12,19],
// [3,6,9,16,22],
// [10,13,14,17,24],
// [18,21,23,26,30]
// ], target = 5
//Output: true


    }

    public boolean searchMatrix(int[][] matrix, int target) {
        int rows = 0;
        int cols = matrix[0].length-1;



        while (cols >= 0 && rows <= matrix.length-1) {
//            int mid = lo +(hi - lo)/2;

            if (target == matrix[rows][cols]) return true;
            else if (target < matrix[rows][cols]) {
                cols--;
            } else if (target > matrix[rows][cols]) {
                rows++;


            }

        }
        return false;
    }


}
