import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Lc124_BinaryTreeMaxPath_H {

    // to get the max path sum, we need to consider negative numbers, and if we are
    // going to exculde them
    // the other issue that may arise is that we store the sum of multiple paths
    // in like a triangle shape and continue to build on it, this would be incorrect
    // to resolve this problem we store a max value, that will store all these triangles as possible solutions
    // and we return only the root.val + the max of the left and righ branch
    int max = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
        helper(root);
        return max;
    }

    // helper returns the max branch
    // plus current node's value
    int helper(TreeNode root) {
        if (root == null) return 0;

        int left = Math.max(helper(root.left), 0);
        int right = Math.max(helper(root.right), 0);

        max = Math.max(max, root.val + left + right);

        return root.val + Math.max(left, right);
    }




    // O(n) time | O(log(n)) space algoexpert
    public static int maxPathSum(BinaryTree tree) {
        List<Integer> maxSumArray = findMaxSum(tree);
        return maxSumArray.get(1);
    }
    public static List<Integer> findMaxSum(BinaryTree tree) {
        if (tree == null) {
            return new ArrayList<Integer>(Arrays.asList(0, 0));
        }
        List<Integer> leftMaxSumArray = findMaxSum(tree.left);
        Integer leftMaxSumAsBranch = leftMaxSumArray.get(0);
        Integer leftMaxPathSum = leftMaxSumArray.get(1);

        List<Integer> rightMaxSumArray = findMaxSum(tree.right);
        Integer rightMaxSumAsBranch = rightMaxSumArray.get(0);
        Integer rightMaxPathSum = rightMaxSumArray.get(1);

        // calculating which child should be taken into consideration
        Integer maxChildSumAsBranch = Math.max(leftMaxSumAsBranch, rightMaxSumAsBranch);

        Integer maxSumAsBranch = Math.max(maxChildSumAsBranch + tree.value, tree.value);

        // calculating triangle
        Integer maxSumAsRootNode =
                Math.max(leftMaxSumAsBranch + tree.value + rightMaxSumAsBranch, maxSumAsBranch);

        // running sum
        int maxPathSum = Math.max(leftMaxPathSum, Math.max(rightMaxPathSum, maxSumAsRootNode));
        return new ArrayList<Integer>(Arrays.asList(maxSumAsBranch, maxPathSum));
    }

    static class BinaryTree {
        public int value;
        public BinaryTree left;
        public BinaryTree right;
        public BinaryTree(int value) {
            this.value = value;
        }
    }
    public static void main(String[] args) {

    }
}
