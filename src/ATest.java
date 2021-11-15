import java.util.Arrays;
import java.util.Collections;
import java.util.*;


public class ATest {


    public static void main(String[] args) {

            int [][] arr1= new int[][] {{1,2}, {5,3}, {2,4}};
            int [][] arr2= new int[][] {{1,2}, {5,3}, {2,4}};
            int [][] arr3= new int[][] {{1,2}, {5,3}, {2,4}};


            Arrays.sort(arr1, (a,b) -> a[0]-b[0]);
            Arrays.sort(arr2, (b,a) -> a[0]-b[0]); // Descending
            Arrays.sort(arr3, (a,b) -> b[0]-a[0]); // Descending order



            System.out.println(Arrays.deepToString(arr1));
            System.out.println(Arrays.deepToString(arr2));
            System.out.println(Arrays.deepToString(arr3));

        System.out.println(Integer.compare(1,3));
        System.out.println(Integer.compare(3,3));



        }
}
