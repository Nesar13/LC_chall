public class Lc62_UniquePaths_M {

    public static int uniquePaths(int m, int n) {

        int [][] memo=new int[m][n];

        return helper(0,0,  memo);




    }

    public static  int helper(int i, int j, int [][] memo){

     if (i> memo.length-1) return 0;
     if (j>memo[0].length-1) return 0;

     if (i==memo.length-1 && j==memo[0].length-1) return 1;
     if (memo[i][j]> 0) return memo[i][j];
     memo[i][j]= helper(i+1, j, memo) + helper (i, j+1, memo);

     return memo[i][j];



}
    public static int uniquePaths2(int m, int n) {



        return helper2(0,0,  m, n);




    }
    public static  int helper2(int i, int j, int m, int n){

        if (i> m-1) return 0;
        if (j> n-1) return 0;

        if (i==m-1 && j==n-1) return 1;

        return helper2(i+1, j,m,n) + helper2 (i, j+1,m, n);



    }
    public static void main(String[] args) {
//        Example 3:
//        Input: m = 7, n = 3
//        Output: 28

//        Example 4:
//
//        Input: m = 3, n = 3
//        Output: 6


        System.out.println(uniquePaths2(7, 3));

    }
}
