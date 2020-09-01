public class Lc191_NumOfBits {


    // same solution 100% faster because you increment 'c'
    public int hammingWeight(int n) {
        int c = 0;
        while (n != 0) {
            if ((n & 1) == 1) c++;  // n &1 returns 1 if the right most bit is 1
            n >>>= 1;  // shift to the right by 1 to check next bit
        }
        return c;

    }

    public static void main(String[] args) {

    }
}
