public class Lc25_ValidPalindrom {



    public static Boolean isPalindrome(String s) {
        int start=0;
        int end=s.length()-1;
        String s2=s.toLowerCase();
        char [] c=s2.toCharArray();

        while(start<end) {
            if(!Character.isLetterOrDigit(c[start])) start++;
            if(!Character.isLetterOrDigit(c[end])) end--;
            if(Character.isLetterOrDigit(c[start]) && Character.isLetterOrDigit(c[end])){
                if (c[start] == c[end]){
                start++;
                end--; }
                else return false;

            }

        }
return true;

    }
    public static void main(String[] args) {


        String s="A man, a plan, a canal: Panam";



        System.out.println(isPalindrome(s));


    }
}
