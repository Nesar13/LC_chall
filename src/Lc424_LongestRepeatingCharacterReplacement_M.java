public class Lc424_LongestRepeatingCharacterReplacement_M {


    public static void main(String[] args) {
        String str = "AABABBA";

        System.out.println(characterReplacement(str, 1));

    }

    public static int characterReplacement(String s, int k) {
        int len = s.length();
        int[] count = new int[26];
        int start = 0, maxCharCount = 0, maxLength = 0;
        for (int end = 0; end < len; end++) {
            // maxCharCount takes the current highest freq of letters so far
            maxCharCount = Math.max(maxCharCount, ++count[s.charAt(end) - 'A']);
            // we find the window length, subtract the highest repeating character that is in array
            // if it is greater than k, decrement the frequency of left-side character
            // note that end-start+1 is always used for window length
            if (end - start + 1 - maxCharCount > k) {
                count[s.charAt(start) - 'A']--;
                start++;
            }
            // maxLength is the answer
            maxLength = Math.max(maxLength, end - start + 1);
        }
        return maxLength;
    }


}


