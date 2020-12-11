public class Lc978_LongestTurbuentSubArray_M {


    public static int maxTurbulenceSize(int[] A) {
        int N = A.length;
        int ans = 1;
        int anchor = 0;

        for (int i = 1; i < N; ++i) {
            int c = Integer.compare(A[i-1], A[i]);
            if (c == 0) {
                anchor = i;
            } else if (i == N-1 || c * Integer.compare(A[i], A[i+1]) != -1) {
                ans = Math.max(ans, i - anchor + 1);
                anchor = i;
            }
        }

        return ans;
    }

    public static void main(String[] args) {

        int [] arr= {9,4,2,10,7,8,8,1,9};

        System.out.println(maxTurbulenceSize(arr));
    }
}
