public class Lc1898_MaxNumRemovableCharacters_M {


    public int maximumRemovals(String s, String p, int[] removable) {

        // What do I binary search then? I find the number of elements I can remove!
        // The left boundary represents the lower limit (0 at first) while the right boundary represents the upper limit (the length of the removable array)
        // Each time, I find the middle number (which is an attempt to remove that number of letters from the string)
        // I also use an array of characters and replace those letters removed with the '/' symbol (can choose anything as long as it's a non-letter)
        // This should be faster and more convenient to work with as compared to removing letters directly from a string (high time complexity from string concatenation)

        //Firstly, I express the letters into an array of characters
        char[] letters = s.toCharArray();
        //Set up my boundaries.
        int l = 0, r = removable.length;
        while (l <= r) {
            //'mid' represents how many letters I remove this round.
            int mid = (l+r)/2;
            //'Remove' those letters!
            for (int i=0;i<mid;i++) letters[removable[i]] = '/';

            //I perform a simple check to see if p is still a subsequence of it. If it is, change the lower boundary.
            if (check(letters,p)) l = mid+1;

                //Otherwise, I replace back all the letters that I had removed.
                //Then, I change the upper boundary.
            else {
                for (int i=0;i<mid;i++) letters[removable[i]] = s.charAt(removable[i]);
                r = mid-1;
            }
        }
        return r;
    }

    //This is a standard procedure for checking if p is a subsequence of the array of characters.
    //I use two-pointers to keep track of which char I'm looking at now in the char array, and another to keep track of which char I'm looking at in p.
    // If the character wasn't 'removed' (remember this is indicated by the '/' symbol) and the characters are equal, I increment both pointers.
    //Otherwise, I only increment the first pointer pointing to the array of characters.
    public boolean check(char[] letters, String p) {
        int i1 = 0, i2 = 0;
        while (i1 < letters.length && i2 < p.length()) {
            char curr = letters[i1], curr2 = p.charAt(i2);
            if (curr != '/' && curr == curr2) i2++;
            i1++;
        }

        //If i2 == p.length(), it means that I had managed to match all of the characters in String p!
        if (i2 == p.length()) return true;
        return false;
    }




    public static void main(String[] args) {
        String s = "abcacb", p = "ab";
        int [] removable = {3,1,0};

        String s1 = "qobftgcueho";
        String s2="obue";
        int [] arr={5,3,0,6,4,9,10,7,2,8};

        //Input: s = "abcab", p = "abc", removable = [0,1,2,3,4]
        //Output: 0
        //Explanation: If you remove the first index in the array removable, "abc" is no longer a subsequence.

        //System.out.println(maximumRemovals(s1, s2, arr));
    }


}
