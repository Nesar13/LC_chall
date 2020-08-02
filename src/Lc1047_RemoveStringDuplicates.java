import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Lc1047_RemoveStringDuplicates {


        public static String removeDuplicates(String S) {
            if(S==null || S.length() <=1) return S;
            Stack<Character> stack = new Stack();
            String res = "";
            //note the i-- as it is pushing  the string in reverse
            for(int i = S.length()-1; i >= 0;  i-- ) {
                System.out.println("character at i: "+ S.charAt(i)+"-----------------------");
                if(!stack.isEmpty() && stack.peek() == S.charAt(i)) {
                    stack.pop();
                    System.out.println("Current stack:" + stack.toString());
                }
                else {
                    stack.push(S.charAt(i));
                    System.out.println("Current stack when pushed:" + stack.toString());
                }
            }
            while(!stack.isEmpty()) {
                res += stack.pop();
                System.out.println("printing result: "+ res);
            }

            return res;
        }
        //using stringbuilder faster than above
    public static String removeDuplicates2(String S) {

        Stack<Character> stk=new Stack<>();

        for(int i=S.length()-1;i>=0;i--) {

            if(!stk.isEmpty()&& stk.peek()==S.charAt(i))
                stk.pop();
            else
                stk.push(S.charAt(i));
        }

        StringBuilder sb=new StringBuilder();

        while(!stk.isEmpty())
            sb.append(stk.pop());

        return sb.toString();
        }

        public static void main(String[] args) {
            String s="abbaca";

            System.out.println(removeDuplicates2(s));
        }
    }

