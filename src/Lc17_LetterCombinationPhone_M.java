import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Lc17_LetterCombinationPhone_M {


//    public static List<String> letterCombinations(String digits) {
//        List<String> res=new ArrayList<>();
//
//        HashMap<Character, String> map=new HashMap<>(){{
//            put('2', "abc");
//            put('3', "def");
//            put('4', "ghi");
//            put('5', "jkl");
//            put('6', "mno");
//            put('7', "pqrs");
//            put('8', "tuv");
//            put('9', "wxyz");
//
//        }
//        };
//
//        StringBuilder sb= new StringBuilder();
//       helper(map, res,  digits, 0, "");
//
//       return res;
//
//
//    }
//
//    private static void helper(HashMap<Character, String> map, List<String> res, String digits, int start, String temp) {
//        if (start >= digits.length() ) res.add(temp);
//
//        for(int end=start; end < digits.length(); end++ ) {
//            if (temp.length() != 1) {
//                temp=temp + map.get(digits.charAt(end)).substring(start, end);
//            }
//           helper(map, res, digits, end+1, temp);
//
//          temp=temp.substring(0, temp.length()-1);
//
//
//        }
//
//    }

   static Map<String, String> phone = new HashMap<String, String>() {{
        put("2", "abc");
        put("3", "def");
        put("4", "ghi");
        put("5", "jkl");
        put("6", "mno");
        put("7", "pqrs");
        put("8", "tuv");
        put("9", "wxyz");
    }};

   // use backtracking to recursively add the combination of strings from the hashmapped
    // numbers and their associated letters
    // you store a letter and recursively add other letters
    // 86%
   static List<String> output = new ArrayList<String>();

    public static void backtrack(String temp, String next_digits) {
        // if there is no more digits to check
        if (next_digits.length() == 0) {
            // the temp is done
            output.add(temp);
        }
        // if there are still digits to check
        else {
            // iterate over all letters which map
            // the next available digit
            String digit = next_digits.substring(0, 1);
            String letters = phone.get(digit);
            for (int i = 0; i < letters.length(); i++) {
                String letter = phone.get(digit).substring(i, i + 1);
                // append the current letter to the temp
                // and proceed to the next digits
                backtrack(temp + letter, next_digits.substring(1));
            }
        }
    }

    public static List<String> letterCombinations(String digits) {
        if (digits.length() != 0)
            backtrack("", digits);

        return output;
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

        System.out.println("hello".substring(1));


    }
}
