import java.util.Arrays;

public class Lc48_RotateImage_M {
public int[][] rotate(int[][] matrix) {
    for (int [] rows : matrix){

        for(int cols: rows) {
            return matrix;
        }
    }
    return matrix;
}
    public static void main(String[] args) {
//        int [][] arr = {{1,2,3},{4,5,6}, {7,8,9}}; // rows
        int [][] arrs =
                {{1,2,3},
                {4,5,6},
                {7,8,9}};

        for (int i = 0; i < arrs.length; i++) {
            int[] arr = arrs[i];

            System.out.println("first: " + Arrays.toString(arr));
            Arrays.stream(arr).mapToObj(num -> "second: " + num).forEach(System.out::println);
        }
        System.out.println(Arrays.deepToString(arrs));
    }
}
