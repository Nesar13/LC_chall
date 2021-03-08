import java.util.Arrays;
import java.util.List;

public class Lc139_WordBreak_M {

    public static void main(String[] args) {
//Input: s = "applepenapple", wordDict = ["apple","pen"]
//Output: true

// Input: s = "catsandog", wordDict = ["cats","dog","sand","and","cat"]
//Output: false
        String s="catsandog";
        List <String> wordDict= Arrays.asList("cats", "dog", "sand", "and", "cat");


        System.out.println(wordBreak2(s, wordDict));


    }

    public boolean wordBreak(String s, List<String> wordDict) {


       return dfs(s, wordDict, 0, 0, "");



    }

    private boolean dfs(String s, List<String> wordDict, int start, int end, String temp) {


        if (end == s.length() - 1) {
            return true;

        }
        if (wordDict.contains(temp)) {
            return true;
        }

        for (int i = start; i <s.length() ; i++) {

            String st=s.substring(i, end);

            dfs(s, wordDict, start, end++, st);


        }
return false;
        }

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

                // we check if we are either at the beginning of the string
                // or if our dp was true on the previous word
                if (dict.contains(sub) && (j == 0 || dp[j - 1])) {
                    dp[i] = true;
                    break;
                }
            }
        }

        return dp[n - 1];
    }
    }
