import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Lc797_AllPathsFromSourcetoTarget_M {
    public static List<List<Integer>> allPathsSourceTarget(int[][] graph) {


        List<List<Integer>> res = new ArrayList<>();
        List<Integer> path = new ArrayList<>();

        path.add(0);
        dfsSearch(graph, 0, res, path);

        return res;
    }

    private static void dfsSearch(int[][] graph, int node, List<List<Integer>> res, List<Integer> path) {
        // we want to add the list to result only when we included all the nodes
        // excluding 0
        if (node == graph.length - 1) {
            res.add(new ArrayList<Integer>(path));
            return;
        }
        // nextNode will look at the inner list and will be used to search the adjacent node
        // since it is related by index
        for (int nextNode : graph[node]) {
            path.add(nextNode);
            dfsSearch(graph, nextNode, res, path);
            path.remove(path.size() - 1);
        }
    }

    public static void main(String[] args) {
       /* List<List<Integer>> list=new ArrayList<>();
        List<Integer> list1=new ArrayList<Integer>(
            Arrays.asList(1,2));
        List<Integer> list2=new ArrayList<Integer>(
            Arrays.asList(3));

        List<Integer> list3=new ArrayList<Integer>(
            Arrays.asList(3));
        List<Integer> list4=new ArrayList<Integer>(
            Arrays.asList());

        list.add(list1);
        list.add(list2);
        list.add(list3);
        list.add(list4);*/

        int[][] arr= {{1,2}, {3}, {3}, {}};

//        System.out.println(list);

        System.out.println(allPathsSourceTarget(arr));







    }
}
