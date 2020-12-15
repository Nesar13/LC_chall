import java.util.HashSet;

public class Lc992_SubarraysWithKDifferentIntegers_M {

    public static int subarraysWithKDistinct(int[] A, int K) {
        int res = 0, prefix = 0;
        int[] m = new int[A.length + 1];
        for (int i = 0, j = 0, cnt = 0; i < A.length; ++i) {
            if (m[A[i]]++ == 0) ++cnt;
            if (cnt > K) {
                --m[A[j++]]; --cnt; prefix = 0;
            }
            while (m[A[j]] > 1) {
                ++prefix; --m[A[j++]];
            }
            if (cnt == K) res += prefix + 1;
        }
        return res;
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 1, 3, 2};

        System.out.println(subarraysWithKDistinct(arr, 2));
    }
}
