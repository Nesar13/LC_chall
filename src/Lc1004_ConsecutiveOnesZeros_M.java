public class Lc1004_ConsecutiveOnesZeros_M {


    public static int longestOnes(int[] A, int K) {
        int left = 0, right;
        for (right = 0; right < A.length; ++right) {
            if (A[right] == 0) K--;
            if (K < 0 && A[left++] == 0) K++;
        }
        return right - left;
    }
    public static void main(String[] args) {
        int[] arr= {1,0,1,1,0,0,0,0};


        System.out.println(longestOnes(arr, 2));
    }
}
