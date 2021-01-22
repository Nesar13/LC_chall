import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Lc17_LetterCombinationPhone_M {


    public static List<String> letterCombinations(String digits) {
        List<String> res=new ArrayList<>();

        HashMap<Character, String> map=new HashMap<>(){{
            put('2', "abc");
            put('3', "def");
            put('4', "ghi");
            put('5', "jkl");
            put('6', "mno");
            put('7', "pqrs");
            put('8', "tuv");
            put('9', "wxyz");

        }
        };

        StringBuilder sb= new StringBuilder();
       helper(map, res,  digits, 0, sb);

       return res;


    }

    private static void helper(HashMap<Character, String> map, List<String> res, String digits, int start, StringBuilder sb) {
        if(sb==null) return;
        if (start >= digits.length() ) res.add(sb.toString());

        for(int end=start; end < digits.length(); end++ ) {
            if (sb.length() != 1) {
                sb.append(map.get(digits.charAt(end)).substring(start, end));
            }
           helper(map, res, digits, end+1, sb);

          sb.deleteCharAt(sb.length()-1);


        }

    }

    public static void main(String[] args) {
//Example 1:
//
//Input: digits = "23"
//Output: ["ad","ae","af","bd","be","bf","cd","ce","cf"]
//Example 2:
//
//Input: digits = ""
//Output: []
//Example 3:
//
//Input: digits = "2"
//Output: ["a","b","c"]
        System.out.println(letterCombinations("23"));
    }
}
