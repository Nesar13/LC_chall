import java.util.Arrays;

public class Lc1886_DetermineWhetherMatrixCanBeRotated {

    public static boolean findRotation(int[][] mat, int[][] target) {
        outer:
        for(int i = 0;i < 4;i++){
            mat = rot(mat);
            for(int j = 0;j < mat.length;j++){
                if(!Arrays.equals(mat[j], target[j])){
                    continue outer;
                }
            }
            return true;
        }
        return false;
    }

    public static int[][] rot(int[][] a)
    {
        int n = a.length, m = a[0].length;
        int[][] b = new int[m][n];
        for(int i = 0;i < n;i++){
            for(int j = 0;j < m;j++){
                b[j][n-1-i] = a[i][j];
            }
        }
        return b;
    }

    public static void main(String[] args) {
        int [][] mat = {{0,0,0},{0,1,0},{1,1,1}}, target = {{1,1,1},{0,1,0},{0,0,0}};

        System.out.println(findRotation(mat, target));
    }

}
