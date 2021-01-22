import java.util.ArrayList;
import java.util.List;

public class Lc103_BinaryTreeZigZagLevelTraversal_M {
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
    // we recursively add the values in a preorder fashion into a list of list and
    // use the depth to add to the specified index
    // we use a modular to indicate that we to add the second level and on in a different manner
    // i.e add to the beginning of list
    // 100 % O(n)
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
List<List<Integer>> res= new ArrayList<>();

helper(root, res, 0);
return res;
    }

    private void helper(TreeNode root, List<List<Integer>> res, int depth) {


        if (root==null) return;

        if (depth >= res.size()) res.add(new ArrayList<>());

if ( depth % 2==0)
        res.get(depth).add(0, root.val);
else{ res.get(depth).add(root.val);}

        helper(root.right, res,depth+1 );
        helper(root.left, res, depth+1);


    }

    public static void main(String[] args) {
        //        Given binary tree [3,9,20,null,null,15,7],
//         3
//        / \
//       9   20
//          /  \
//         15   7
//        return its zigzag level order traversal as:
//[
//  [3],
//  [20,9],
//  [15,7]
//]

        TreeNode root= new TreeNode();



    }
}
