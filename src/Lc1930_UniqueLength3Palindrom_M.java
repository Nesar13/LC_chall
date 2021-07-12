import java.util.Arrays;

public class Lc1930_UniqueLength3Palindrom_M {

// so we create two arrays that keeps track of the
    // index of the same characters at the beginning and at the end, if it exists
    // we call them first and last
    // we will try to get all the unique characters in between the two
    // of the same character

    public static int countPalindromicSubsequence(String s) {
        int first[] = new int[26], last[] = new int[26], res = 0;
        Arrays.fill(first, Integer.MAX_VALUE);
        for (int i = 0; i < s.length(); ++i) {
            first[s.charAt(i) - 'a'] = Math.min(first[s.charAt(i) - 'a'], i);
            last[s.charAt(i) - 'a'] = i;
        }
        for (int i = 0; i < 26; ++i)
            if (first[i] < last[i])
                res += s.substring(first[i] + 1, last[i]).chars().distinct().count();
        return res;
    }

    public static void main(String[] args) {
        System.out.println(countPalindromicSubsequence("bbcbaba"));


        // chars() gets the intstream of all the chars in the string
        // which means that it is an ascii numerical value
        //distinct() gets all the unique char values, and count() returns the total number of
        // char values
        String s="nesara";

        System.out.println(Arrays.toString(s.chars().toArray()));
    }
}
