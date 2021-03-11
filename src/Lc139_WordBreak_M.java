import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Lc139_WordBreak_M {

    public static void main(String[] args) {
//Input: s = "applepenapple", wordDict = ["apple","pen"]
//Output: true

// Input: s = "catsandog", wordDict = ["cats","dog","sand","and","cat"]
//Output: false
        String s = "catsanddog";
        List<String> wordDict = Arrays.asList("cats", "dog", "sand", "and", "cat");


        System.out.println(wordBreak(s, wordDict));


    }

    // use boolean dp to store if a word exists by marking the
    // end of the word as true if it's in the dictionary
    // if the last index is true, then it is possible to create word breaks
    // in the word
    public static boolean wordBreak2(String s, List<String> dict) {
        if (s == null || s.length() == 0) return false;

        int n = s.length();

        // dp[i] represents whether s[0...i] can be formed by dict
        boolean[] dp = new boolean[n];

        for (int i = 0; i < n; i++) {
            // note j <= i which means i is the end
            // j will iterate until i
            for (int j = 0; j <= i; j++) {
                String sub = s.substring(j, i + 1);


                // dp[j-1] is to check if theres a 'space' to begin the current word
                //j==0 is to cover the beginning of the string
                if (dict.contains(sub) && (j == 0 || dp[j - 1])) {
                    dp[i] = true;
                    break;
                }
            }
        }

        return dp[n - 1];
    }
// this is 99
    public static boolean wordBreak(String s, List<String> wordDict) {
        Set<String> set = new HashSet<>(wordDict);
        boolean[] isValidStartIndexArr = new boolean[s.length() + 1];
        int maxLen = 0;
        for(String word:wordDict){
            if(word.length() > maxLen){
                maxLen = word.length();
            }
        }
        isValidStartIndexArr[0] = true;
        //i is the start of substring
        for(int i = 0;i<s.length();i++){
            if(!isValidStartIndexArr[i]) continue;
            //Optimization 1: length of substring will be maxLen; 1ms beat 98.73
            //j is the end of substring
            for(int j = i;j<Math.min(i+maxLen,s.length());j++){
                String temp=s.substring(i,j+1);
                if(set.contains(s.substring(i,j+1))){
                    isValidStartIndexArr[j+1] = true;
                    if(isValidStartIndexArr[s.length()]) return true;
                }
            }
        }
        return false;
    }
}
