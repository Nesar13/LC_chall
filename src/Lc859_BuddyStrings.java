public class Lc859_BuddyStrings {

    public static Boolean buddyStrings(String A, String B) {
        if (A.isEmpty() || B.isEmpty()) return false;

        int left=0;
        int right=A.length() -1;
        while (left < A.length()-1) {

            if (A.charAt(left)==B.charAt(left)) {
                left++;
            } else {
                break;

            }}
        while (right > 0) {
            if (A.charAt((right))==B.charAt(right)) right--;
            else break;

        }
        char [] ca=A.toCharArray();
        char temp=ca[left];
        ca[left]=ca[right];
        ca[right]=temp;

        if( String.valueOf(ca).equals(B)) return true;





        return false; }

    public static void main(String[] args) {
        System.out.println(buddyStrings("", "ab"));
    }
}
