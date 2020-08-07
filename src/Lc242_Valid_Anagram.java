import java.util.Arrays;

public class Lc242_Valid_Anagram {

    //fastest solution
    public static boolean isAnagram(String s, String t) {

            int arr[] = new int[26];
            //increment all the values associated with the s array
            for(char c : s.toCharArray())
                arr[c-'a']++;
            for(char c : t.toCharArray()){
                //check if a character exists as it should have 1, otherwise return false
                if(arr[c-'a'] == 0)
                    return false;
                arr[c-'a']--;
            }
            for(int i=0;i<26;i++)
                if(arr[i]>0)
                    return false;

            return true;

    }

    public static boolean isAnagram2(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        //26 letters in alphabet
        int[] counter = new int[26];
        for (int i = 0; i < s.length(); i++) {
            //incrementing to the value of zero or decrementing
            counter[s.charAt(i) - 'a']++;
            counter[t.charAt(i) - 'a']--;
        }
        for (int count : counter) {
            if (count != 0) {
                return false;
            }
        }
        return true;
    }


    public static void main(String[] args) {

        String s = "anagram";
        String t = "nagaam";


        System.out.println(Arrays.toString(t.toCharArray()));
        char[] chars=t.toCharArray();
        Arrays.sort(chars);
        System.out.println(Arrays.toString(chars));
        System.out.println('b'-'a');
        System.out.println(isAnagram(s,t));

    }

}
