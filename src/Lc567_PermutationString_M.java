public class Lc567_PermutationString_M {

    public static boolean checkInclusion(String s1, String s2) {

        int[] freqArr=new int[26];

        for (int i = 0; i < s1.length(); i++) {
            freqArr[s1.charAt(i)-'a']--;

        }

        for (int i = 0; i < s2.length() ; i++) {
            freqArr[s1.charAt((i)-'a')]++;

        }
return false;
    }

    public static void main(String[] args) {
//
    }
}
