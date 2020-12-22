import java.util.HashSet;

public class Lc992_SubarraysWithKDifferentIntegers_H {


    // prefix keeps track of possible solutions in a subarray
    // 100%
    public static int subarraysWithKDistinct(int[] A, int K) {
        int res = 0, prefix = 0;
        int[] freqArr = new int[A.length + 1];
        for (int end = 0, start = 0, count = 0; end < A.length; ++end) {
            if (freqArr[A[end]]++ == 0) ++count;
            if (count > K) {
                --freqArr[A[start++]]; --count; prefix = 0;
            }
            while (freqArr[A[start]] > 1) {
                ++prefix; --freqArr[A[start++]];
            }
            if (count == K) res += prefix + 1;
        }
        return res;
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 1, 2, 3};
        // 5,7,5,2,3,3,4,1,5,2,7,4,6,2,3,8,4,5,7
        // K = 7

        System.out.println(subarraysWithKDistinct(arr, 2));

        int a=0;
        int b=0;
        System.out.println( a++); // 0
        System.out.println(++b); // 1
        System.out.println(a); // 1
    }
}
