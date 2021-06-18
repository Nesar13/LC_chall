import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Lc71_SimplifyPath_M {

    // we filter our given path by / and . which is just the current directory
    // we have to consider when there's ../../foo since we will go to two previous directories
    // we also have to consider if we have a relative path or an absolute path
    // so we have to add an empty string if it's a relative path
    // use a stack to check for the previous string token and see if it's relevent -
    // we know if it's irrelevant if it has . and if .. we ust use the previous token
    // O(n) time | O(n) space
    public String simplifyPath(String path) {

        boolean startsWithPath = path.charAt(0) == '/';
        String[] tokensArr = path.split("/");
        List< String > tokensList = Arrays.asList(tokensArr);
        // we can replace lambda with a method reference
        //List < String > filteredTokens = tokensList.stream().filter(token -> isImportantToken(token)).collect(Collectors.toList());
        List < String > filteredTokens = tokensList.stream().filter(Lc71_SimplifyPath_M::isImportantToken).collect(Collectors.toList());


        List < String > stack = new ArrayList< String >();
        if (startsWithPath) stack.add("");

        for (String token: filteredTokens) {
            if (token.equals("..")) {
                if (stack.size() == 0 || stack.get(stack.size() - 1).equals("..")) {
                    stack.add(token);
                } else if (!stack.get(stack.size() - 1).equals("")) {
                    stack.remove(stack.size() - 1);
                }
            } else {
                stack.add(token);
            }
        }
        if (stack.size() == 1 && stack.get(0).equals("")) return "/";
        return String.join("/", stack);
    }

    public static boolean isImportantToken(String token) {
        return token.length() > 0 && !token.equals(".");
    }

}
