import java.util.Arrays;

public class Lc48_RotateImage_M {



    public static void rotate(int[][] matrix) {
        int n = matrix.length;

        // transpose matrix
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                int tmp = matrix[j][i];
                matrix[j][i] = matrix[i][j];
                matrix[i][j] = tmp;
            }
        }
        // reverse each row
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n / 2; j++) {
                int tmp = matrix[i][j];
                matrix[i][j] = matrix[i][n - j - 1];
                matrix[i][n - j - 1] = tmp;
            }
        }
    }
    public static void main(String[] args) {
//        int [][] arr = {{1,2,3},{4,5,6}, {7,8,9}}; // rows
        int [][] arrs =
                {{1,2,3},
                {4,5,6},
                {7,8,9}};

//        for (int i = 0; i < arrs.length; i++) {
//            int[] arr = arrs[i];
//
//            System.out.println("first: " + Arrays.toString(arr));
//            Arrays.stream(arr).mapToObj(num -> "second: " + num).forEach(System.out::println);
//        }
//        System.out.println(Arrays.deepToString(arrs));

        rotate(arrs);

        System.out.println(Arrays.deepToString(arrs));
    }
}
