import java.util.HashMap;
import java.util.Map;

public class Lc430_PathSumIII_M {

    public static int pathSum(TreeNode root, int sum) {
        if (root == null) {
            return 0;
        }
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        return findPathSum(root, 0, sum, map);
    }
    private static int findPathSum(TreeNode curr, int sum, int target, Map<Integer, Integer> map) {
        if (curr == null) {
            return 0;
        }
        // update the prefix sum by adding the current val
        sum += curr.val;
        // get the number of valid path, ended by the current node
        int numPathToCurr = map.getOrDefault(sum-target, 0);
        // update the map with the current sum, so the map is good to be passed to the next recursion
        map.put(sum, map.getOrDefault(sum, 0) + 1);
        // add the 3 parts discussed in 8. together
        int res = numPathToCurr + findPathSum(curr.left, sum, target, map)
                + findPathSum(curr.right, sum, target, map);
        // restore the map, as the recursion goes from the bottom to the top
        map.put(sum, map.get(sum) - 1);
        return res;
    }

    public static void main(String[] args) {
        // [10,5,-3,3,2,null,11,3,-2,null,1]
        TreeNode root=new TreeNode(10);
        root.left=new TreeNode(5);
        root.right=new TreeNode(-3);

        root.left.left=new TreeNode(3);
        root.left.right=new TreeNode(2);

        root.right.right=new TreeNode(11);


        root.left.left.left=new TreeNode(3);
        root.left.left.right=new TreeNode(-2);

        root.left.right.right=new TreeNode(1);


        System.out.println(pathSum(root, 8));



    }



}
