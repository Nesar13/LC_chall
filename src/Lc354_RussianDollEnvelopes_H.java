import java.util.Arrays;

public class Lc354_RussianDollEnvelopes_H {

    // we sort the envelopes by the width or height, we sorted it by height
    // we create a dp array to store how many ways we stack envelopes
    // {{2,3}, {3,4}, {2,5}, {4,6}} our dp array would be {1,2,1,3}
    // we have two loops where we iterate to i from 0, so we can check if
    // each envelope fits the criteria and add onto it's dp if it does
    // TC: O(n^2) SC:O(n)
    public static int maxEnvelopes(int[][] envelopes) {

        if (envelopes.length==0) return 0;
        int max=1;
        Arrays.sort(envelopes, (a, b) -> Integer.compare (a[1],b[1]));

        int [] maxDolls=new int[envelopes.length];
        Arrays.fill(maxDolls, 1);

        for (int i=1; i<envelopes.length; i++){
            int w0 = envelopes[i][0];
            int h0 = envelopes[i][1];

            for (int j=0; j < i ; j++ ) {

                int w1=envelopes[j][0];
                int h1= envelopes[j][1];

                if (w1< w0 && h1 < h0) {
                    maxDolls[i]=Math.max(maxDolls[j]+1, maxDolls[i]);

                }


            }
            max=Math.max(max, maxDolls[i]);


        }
        return max;
    }
    public static void main(String[] args) {
//[[5,4],[6,4],[6,7],[2,3]]

        int [][] arr={{5,4},{6,4},{6,7},{2,3}};

        System.out.println(maxEnvelopes(arr));
    }
}
