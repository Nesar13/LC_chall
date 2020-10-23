import java.util.HashMap;
import java.util.Stack;

public class Lc20_ValidParenthesis {


    public static boolean isValid(String s) {

        // put all the closing characters in hashmap to compare to stack
        // since stack.pop will have to be the corresponding open bracket
        HashMap<Character,Character> maps=new HashMap<Character,Character>();
        maps.put(')','(');
        maps.put(']','[');
        maps.put('}','{');
        Stack<Character> stack=new Stack<Character>();
        for(int i=0;i<s.length();i++){
            char c=s.charAt(i);
            if(maps.containsKey(c)){
                // if we reached a closing bracket, return false if stack is empty
                // also return false if stack.pop != the closing bracket
                // note that stack is popped regardless as every inovocation of stack.pop will execute
                if(stack.empty()||stack.pop()!=maps.get(c))return false;
            }
            else
                stack.push(c);
        }
        // this returns true if stack is empty -- we are finished
        return stack.empty();
    }

    public static void main(String[] args) {
        String s="({{}})";

    Stack<String> stack = new Stack<>();


    System.out.println(isValid(s));

    }
}
