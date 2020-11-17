import java.util.ArrayList;
import java.util.List;

public class Lc102_BinaryTreeLevelOrder_M {
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

    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        List <Integer> temp = new ArrayList<>();

        helper(root, res, temp, 0);

        return res;

    }

        private void helper(TreeNode root, List<List<Integer>> res, List<Integer> temp, int level) {

            temp.add(root.val);





        }
        }

        public static void main(String[] args) {

    }
}
