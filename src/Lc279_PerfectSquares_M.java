import java.util.ArrayList;

public class Lc279_PerfectSquares_M {

    static ArrayList<Integer> arr = new ArrayList<>();
    static int res=Integer.MAX_VALUE;
    public  static int numSquares(int n) {
        for (int i = 0; i < n; i++) {
            isPerfectSquare(0, i);

        }
dfs( new ArrayList(),  n, 0);

return res;

    }


    public static void dfs(ArrayList temp, int n, int sum) {
        if (sum==n ) res=Math.min(temp.size(), res);

        for (int end = 0; end  < arr.size() ; end++) {
            temp.add(arr.get(end));
            sum+=arr.get(end);

            dfs(temp,n,  sum);
            sum -= arr.get(end);
        }




    }

    public static void isPerfectSquare(int count, int primeCheck) {
        if (count == primeCheck/2 + 1 ) return ;
        if (count * count == primeCheck) {
            arr.add(count);
            return;
        }



       isPerfectSquare(count+1, primeCheck);
    }


    public static void main(String[] args) {

//        System.out.println(isPerfectSquare(0, 25));

        System.out.println(numSquares(13));
        //Example 1:
        //Input: n = 12
        //Output: 3
        //Explanation: 12 = 4 + 4 + 4.

        //Example 2:
        //Input: n = 13
        //Output: 2
        //Explanation: 13 = 4 + 9
        //Constraints:

        //1 <= n <= 104

    }
}
