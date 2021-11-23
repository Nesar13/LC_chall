import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Lc1156_SwapForLongestRepeatedCharacter {
    // we can break this problem into two main parts:
    // 1) when we have aabaa, we will have to merge the left and right parts
    //    since we can replace b
    // 2) when we have a case like aabba we will have to add 1
    //    to get the result of 3 since b can be replaced with 1
    // We can do them by having a index table with hashmap
    // hashmap <key: Char , value: List of indexes>
    // then we can iterate through each character index and store
    // the left side and right side when we have cases like aabaa
    // and then add them to our sum
    // O(n) time since we only iterate through the string once
    // O(n) space since we have to store each char
    public static int maxRepOpt1(String text) {

        HashMap<Character, List<Integer>> map=new HashMap<>();
        // creating a hashmap of character indexes from our string
        for(int i=0;i<text.length();i++){
            char c=text.charAt(i);
            if(!map.containsKey(c)) map.put(c,new ArrayList<>());
            map.get(c).add(i);
        }
        int res=0;
        for(List<Integer> list:map.values()){
            int cur=1,pre=0,sum=1;
            for(int i=1;i<list.size();i++){
                // if characters are next to each other
                // we just increment
                if(list.get(i)==list.get(i-1)+1)
                    cur++;
                else { // if characters are two indexes apart (there's a letter in between)
                    // simulate a swap. so we track the left side(prev) and eventually add the right side
                    // to our total sum
                    pre= list.get(i)==list.get(i-1)+2? cur:0;
                    cur=1;
                }
                //Pre will be the left side and curr will  be the right side
                // so if we have aabaa, we will merge the left and right
                // so it would be 4
                sum=Math.max(sum,cur+pre);
            }
            // ternary is saying if we have an extra character left that we
            // use to swap (if the sum is less than the number of the same chars)
            // we add 1 to our sum
            res=Math.max(res,sum+(sum<list.size()?1:0));
        }
        return res;
    }
    public static void main(String[] args) {


        String s ="ababa";

        System.out.println(maxRepOpt1(s));

    }
}
