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

        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {

                pq.add(matrix[i][j]);

                if (pq.size() > k) pq.poll();


            }
        }


        return pq.poll();

    }

    //
    public static int kthSmallest2(int[][] matrix, int k) {
        // lo is the first value in the array, hi is the last value plus one
        int lo = matrix[0][0], hi = matrix[matrix.length - 1][matrix[0].length - 1] ;//[lo, hi)
        while (lo < hi) {
            int mid = lo + (hi - lo) / 2;
            int count = 0, j = matrix[0].length - 1;
            for (int i = 0; i < matrix.length; i++) {
                while (j >= 0 && matrix[i][j] > mid)
                    j--;
                // will account for all previous nums in subArray
                // since we know that the current j is less than mid and all nums to the left
                // will be lower by definition of this problem
                count += (j + 1);
            }
            // if count is still less than k,
            // then we know we have to update our left side
            // otherwise, we need to update the right side
            if (count < k)
                lo = mid + 1;
            else hi = mid;
        }
        return lo;
    }

    public static void main(String[] args) {
        int[][] matrix = {{1, 5, 9}, {10, 11, 13},
               {12, 13, 15}}; // k=8 answer 13

//        int [][] matrix= {{1,2,3}, {3,4,8}};


        System.out.println(kthSmallest2(matrix, 8));

    }
}
