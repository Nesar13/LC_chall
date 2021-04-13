public class Lc1572_MatrixDiagnolSum {


    public static int diagonalSum(int[][] mat) {

        int p_index=0;
        if (mat[0].length ==1) return mat[0][0];
        int s_index=mat[0].length-1;
        int sum=0;

        for (int i=0; i < mat.length; i++) {

            sum+=  mat[i][p_index++];

            sum += mat[i][s_index--];

            if(p_index==s_index) sum-=mat[i+1][s_index];




        }
        return sum;

    }
    public static void main(String[] args) {
//[[1,2,3],
//              [4,5,6],
//              [7,8,9]]


        int [][] arr= {{1,2,3},{4,5,6}, {7,8,9}};

        System.out.println(diagonalSum(arr));
    }
}
