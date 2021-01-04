import java.util.Collections;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Lc378_KthSmallestElementMatrix_M {

//    matrix = [
//            [ 1,  5,  9],
//            [10, 11, 13],
//            [12, 13, 15]
//            ],
//    k = 8,
//
//            return 13.
    public static int kthSmallest(int[][] matrix, int k) {

        PriorityQueue<Integer> pq= new PriorityQueue<>(Collections.reverseOrder());

        for (int i = 0; i <matrix.length ; i++) {
            for (int j = 0; j < matrix[i].length; j++) {

                pq.add(matrix[i][j]);

                if (pq.size() > k ) pq.poll();



            }
        }


        return pq.poll();

    }
    public static void main(String[] args) {
        int [] [] matrix = {{1, 5, 9},{10, 11, 13},
                {12, 13, 15}};

        System.out.println(kthSmallest(matrix,8));

    }
}
