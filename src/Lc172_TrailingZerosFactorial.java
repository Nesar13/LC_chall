public class Lc172_TrailingZerosFactorial {

    public static int trailingZeroes(int n) {
        int r = 0;
        while (n > 0) {
            n /= 5;
            r += n;
        }
        return r;
    }


    public static void main(String[] args) {

        System.out.println(trailingZeroes(11));
    }

}
