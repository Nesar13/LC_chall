import java.math.BigInteger;

public class Lc202_Happy_number {

    public static boolean isHappy(int n) {
        int temp=0;
        String str;

        for (int i = 0; i <10 ; i++) {
        str=n+"";
        int result=0;
        int len= str.length();
        for (int j = 0; j <len ; j++) {
            temp = n % 10;
            n=n/10;
            result += (temp*temp);
            if (result==100 && j==len-1 || (result==1 && j==len-1)){
                return true;
            }

            }
            n=result;


        }
        return false;


    }


    public static boolean isHappy2(int n) {
        int s = n, f = n; // slow , fast

        do {
            s = compute(s); // slow computes only once
            f = compute(compute(f)); // fast computes 2 times

            if (s == 1) return true; // if we found 1 then happy indeed !!!
        } while (s != f); // else at some point they will meet in the cycle

        return false; // it's a cycle , not happy at all !!!
    }


        public static int compute(int n){
            int s = 0;
            while(n != 0){
                s += (n%10)*(n%10);
                n = n/10;
            }
            return s;
        }


    public static void main(String[] args) {

        System.out.println(isHappy2(168));
        System.out.println(1 >>>1 );
        System.out.println( -32 >> 30);

        System.out.println();


    }
}
