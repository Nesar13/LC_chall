public class Lc151_ReverseString_M {
    static void reverseWords(char[] a, int n) {
        int i = 0, j = 0;

        while (i < n) {
            // notice the boolean (i < j) || (i < n && a[i] == ' ') execution order
            while (i < j || i < n && a[i] == ' ') i++; // skip spaces or catch up to j
            while (j < i || j < n && a[j] != ' ') j++; // skip non spaces , or skip when you're less than i
            reverse(a, i, j - 1);                      // reverse the word from i to j-1 (since j can be at a whitespace
        }
    }
    // reverse a[] from a[i] to a[j]
    private static void reverse(char[] a, int i, int j) {
        while (i < j) {
            char t = a[i];
            a[i++] = a[j];
            a[j--] = t;
        }
    }
    public static void main(String[] args) {
String s="The sky   is blue";

char [] c=s.toCharArray();

        reverseWords(c, c.length);
    }
}
