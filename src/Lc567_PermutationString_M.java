public class Lc567_PermutationString_M {

    public static boolean checkInclusion(String s1, String s2) {

        int[] freqArr=new int[26];
        int windowSize=0;

        for (int i = 0; i < s1.length(); i++) {
            freqArr[s1.charAt(i)-'a']++;

        }

        for (int i = 0; i < s2.length() ; i++) {
            if(windowSize == s1.length()) return true;

            if (freqArr[s2.charAt(i)-'a'] > 0) {
                windowSize++;
            }
            if (windowSize > s1.length())  windowSize--;


        }
        if (windowSize ==s1.length()) return true;


        return false;
    }

    public static void main(String[] args) {
        System.out.println(checkInclusion("adc", "dcda"));
    }
}
