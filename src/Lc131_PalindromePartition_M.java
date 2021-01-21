import java.util.ArrayList;
import java.util.List;

public class Lc131_PalindromePartition_M {


//    public static List<List<String>> partition(String s) {
//        List<List<String>> res = new ArrayList<>();
//        List<String> arr = new ArrayList<>();
//        helper(s, res, arr, 0);
//
//        return res;
//    }
//
//    private static void helper(String s, List<List<String>> res, List<String> arr, int start) {
//
//
//        if (start >= arr.size()) {
//            res.add(new ArrayList<>(arr));
//        }
//
//
//            for (int end = start; end < s.length(); end++) {
//                if(isPalindrome(s, start, end)) {
//
//                arr.add(s.substring(start, end+1));
//                helper(s, res, arr, end+1);
//                arr.remove(arr.size() - 1);
//            }
//
//            }
//    }
//
//    public static Boolean isPalindrome(String s, int left, int right) {
//
//
//        while (left < right) {
//
//            if (s.charAt(left++) != s.charAt(right--)) return false;
//
//        }
//
//        return true;
//
//    }

        // we use backtracking to add substring and check if it's a palindrome
    // if it is a palindrome we add to current sub list
    // we check if start > = s.length since we know that start is equivalent
    // to checking all of the string
    // O(N*2^N) it is 2^N because if there is "aaa" there will be 2^3=8 nodes which is worst case
    // For each substring, it takes O(N) time
    // to generate substring and determine if it a palindrome or not.

        public static List<List<String>> partition(String s) {
            List<List<String>> result = new ArrayList<List<String>>();
            dfs(0, result, new ArrayList<String>(), s);
            return result;
        }

        static void dfs(int start, List<List<String>> result, List<String> currentList, String s) {
            if (start >= s.length())
                result.add(new ArrayList<String>(currentList));
            for (int end = start; end < s.length(); end++) {
                if (isPalindrome(s, start, end)) {
                    // add current substring in the currentList
                    currentList.add(s.substring(start, end + 1));
                    dfs(end + 1, result, currentList, s);
                    // backtrack and remove the current substring from currentList
                    currentList.remove(currentList.size() - 1);
                }
            }
        }

        static boolean isPalindrome(String s, int low, int high) {
            while (low < high) {
                if (s.charAt(low++) != s.charAt(high--)) return false;
            }
            return true;
        }


    public static void main(String[] args) {
//        Example 1:
//
//        Input: s = "aab"
//        Output: [["a","a","b"],["aa","b"]]
//        Example 2:
//
//        Input: s = "a"
//        Output: [["a"]]

       System.out.println(partition("aab"));

        //System.out.println("aab".substring(2,3));
    }
}
