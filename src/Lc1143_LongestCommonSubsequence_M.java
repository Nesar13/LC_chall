public class Lc1143_LongestCommonSubsequence_M {

    public int longestCommonSubsequence(String text1, String text2) {
        int s1=text1.length();
        int s2=text2.length();


        // include the two empty strings in the beginning
        int [] [] arr= new int[s1+1][s2+1];

        for (int i=1; i< s1+1; i++){

            for (int j=1; j< s2+1; j++){
                // check edge cases
                char c1=text1.charAt(i-1);
                char c2=text2.charAt(j-1);

                // if character is the same, we take the top diagonal,
                // otherwise we take the max of the left or the value above
                //
                if(c1==c2)
                    arr[i][j]=arr[i-1][j-1] +1;

                else {
                    arr[i][j]=Math.max(arr[i-1][j], arr[i][j-1]);
                }

            }

        }

        return arr[s1][s2];

    }

}
