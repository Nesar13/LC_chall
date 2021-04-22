public class Lc72_EditDistancr_M {
    // we calculate the Levenshtein distance by putting the the two strings into a matrix with an
    // empty string in the beginning
    // and for each we check how many actions will be needed to create the second char
    // with this, we can determine that we can produce the current value
    // from getting the min of the the surrounding values of the left, left-diagonal, and up
    // TC is O(nxm) and space is O(nxm) although we can reduce it to O(min(n,m) by storing only two rows
    // algoexpert has a video
    public static int minDistance(String word1, String word2) {
        int len1 = word1.length();
        int len2 = word2.length();

        int[][] matrix = new int[len1 + 1][len2 + 1];

        for (int i = 0; i < len2 + 1; i++) {
            matrix[0][i] = i;

        }

        for (int i = 0; i < len1 + 1; i++) {
            matrix[i][0] = i;

        }
        for (int i = 1; i < len1 + 1; i++) {

            for (int j = 1; j < len2 + 1; j++) {

                if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    matrix[i][j] = matrix[i - 1][j - 1];
                } else {

                    matrix[i][j] = 1 + Math.min(matrix[i][j - 1], Math.min(matrix[i - 1][j], matrix[i - 1][j - 1]));

                }
            }

        }

        return matrix[len1][len2];
    }
    public static void main(String[] args) {
       // Input: word1 = "horse", word2 = "ros"
       // Output: 3

        String s1= "horse";
        String s2="ros";

        System.out.println(minDistance(s1, s2));
    }
}
