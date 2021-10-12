public class Lc5_LongestPalindromicSubstring_M {

    // we try to go outwards and keep track of the length
    // of the left and right
    // note that we can have an odd and even legnth palindrome so
    // we have to expand around the center outwards for both situations
    // and take the max length
    //          even        odd
    //                       R
    //        <- LR ->    <- L ->
    //          cbbc        aba
    //O(N^2) time | O(1) space
    public static String longestPalindrome(String s) {
        if (s == null || s.length() < 1) return "";
        int start = 0, end = 0;
        for (int i = 0; i < s.length(); i++) {
            int len1 = expandAroundCenter(s, i, i); // odd len palindromes like aba
            int len2 = expandAroundCenter(s, i, i + 1); // even len palindromes like cbbc
            int len = Math.max(len1, len2);

            // we try to keep track of the longest palindrome substring by getting
            // the start and end since we know the length
            if (len > end - start) {
                start = i - (len - 1) / 2;
                end = i + len / 2;
            }
        }
        return s.substring(start, end + 1);
    }

    private static int expandAroundCenter(String s, int left, int right) {
        int L = left, R = right;
        while (L >= 0 && R < s.length() && s.charAt(L) == s.charAt(R)) {
            L--;
            R++;
        }
        return R - L - 1;
    }

    public static void main(String[] args) {
//Input: s = "cbbd"
//Output: "bb"

        String s="cbbd";
        System.out.println(longestPalindrome(s));



    }





}
