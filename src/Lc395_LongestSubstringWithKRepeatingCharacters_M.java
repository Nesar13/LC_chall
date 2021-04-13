public class Lc395_LongestSubstringWithKRepeatingCharacters_M {

    public static void main(String[] args) {
        System.out.println(longestSubstring("ababacb", 3));
    }


// Divide and conquer solution: we separate the string into parts based on the if a character is less than k
    // we will start after that character (and if we encounter another character < k )
    // return the max of those two parts
    // O(n^2)
    // there is a solution using window sliding, but not very intuitive
    public static int longestSubstring(String s, int k) {
        return helper(s, 0, s.length(), k);
    }

    static int helper(String s, int start, int end, int k) {
        if (end < k) return 0;
        int[] countMap = new int[26];
        // update the countMap with the count of each character
        for (int i = start; i < end; i++)
            countMap[s.charAt(i) - 'a']++;
        for (int mid = start; mid < end; mid++) {
            // we are only checking for <k then we will have to skip that character

            if (countMap[s.charAt(mid) - 'a'] >= k)
                continue;
            int midNext = mid + 1;
            // edgecase if we have more than one character in a row that are <k occurences, we increment midNext
            // to skip those
            while (midNext < end && countMap[s.charAt(midNext) - 'a'] < k)
                midNext++;
            return Math.max(helper(s, start, mid, k),
                    helper(s, midNext, end, k));
        }
        return (end - start);
    }
}
