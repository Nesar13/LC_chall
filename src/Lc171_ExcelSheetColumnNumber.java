public class Lc171_ExcelSheetColumnNumber {

    public static int titleToNumber(String s) {

        int result  = 0;
        for (int i = 0; i < s.length(); i++){
            result *= 26;
            result += ((s.charAt(i) - 'A') + 1);
        }

        return result;
    }

    //mathematical solution...example "ABC" 26^2(A)+26^2(B)+26^0(C)
    public static int titleToNumber2(String s) {
        int result=0;
        int lengthCount  = s.length() -1;

        for (int i = 0; i < s.length(); i++){

            result+=Math.pow(26, lengthCount--) * ((s.charAt(i) - 'A') + 1);

        }

        return result;
    }

    public static void main(String[] args) {

        String s="ABC";

        System.out.println(titleToNumber2(s));
    }
}
