import java.util.HashSet;

public class Lc992_SubarraysWithKDifferentIntegers_M {


    // prefix keeps track of possible distinct integers
    public static int subarraysWithKDistinct(int[] A, int K) {
        int res = 0, prefix = 0;
        int[] m = new int[A.length + 1];
        for (int end = 0, start = 0, count = 0; end < A.length; ++end) {
            if (m[A[end]]++ == 0) ++count;
            if (count > K) {
                --m[A[start++]]; --count; prefix = 0;
            }
            while (m[A[start]] > 1) {
                ++prefix; --m[A[start++]];
            }
            if (count == K) res += prefix + 1;
        }
        return res;
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 1, 2, 3};

        System.out.println(subarraysWithKDistinct(arr, 2));

        int a=0;
        int b=0;
        System.out.println( a++); // 0
        System.out.println(++b); // 1
        System.out.println(a); // 1
    }
}
