import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
//
public class Lc1557_MinNumOfVerticesReachAllNodes_M {

    // we want vertexes that have no indegree
    public static List<Integer> findSmallestSetOfVertices(int n, List<List<Integer>> edges) {
        List<Integer> res = new ArrayList<>();
        int[] seen = new int[n];
        // look through each in list and look at the second num
        // since the the edges are [from, to]
        // we will set each 'to' num to be seen since we only want vertexes that have no indegree
        for (List<Integer> e: edges)
            seen[e.get(1)] = 1;
        for (int i = 0; i < n; ++i)
            if (seen[i] == 0)
                res.add(i);
        return res;
    }

    public static void main(String[] args) {

        List<List<Integer>> list=new ArrayList<>(Arrays.asList());
        List<Integer>list1=new ArrayList<Integer>(
                Arrays.asList(0,1));
        List<Integer>list2=new ArrayList<Integer>(
                Arrays.asList(0,2));
        List<Integer>list3=new ArrayList<Integer>(
                Arrays.asList(2,5));
        List<Integer>list4=new ArrayList<Integer>(
                Arrays.asList(3,4));
        List<Integer>list5=new ArrayList<Integer>(
                Arrays.asList(4,2));

        list.add(list1);
        list.add(list2);
        list.add(list3);
        list.add(list4);
        list.add(list5);

        System.out.println(findSmallestSetOfVertices(6, list));
    }
}
