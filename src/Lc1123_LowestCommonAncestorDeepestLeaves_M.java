public class Lc1123_LowestCommonAncestorDeepestLeaves_M {


    // compare and store max Depth and node if the left and right nodes have same depth
    // tried boolean but didn't realize they wanted the longest depth, even if it's a leaf with
    // no siblings

    // O(n) time | O(1) space
    int deepest = 0;
    TreeNode lca;

    public TreeNode lcaDeepestLeaves(TreeNode root) {
        helper(root, 0);
        return lca;
    }

    private int helper(TreeNode node, int depth) {
        deepest = Math.max(deepest, depth);
        if (node == null) {
            return depth;
        }
        int left = helper(node.left, depth + 1);
        int right = helper(node.right, depth + 1);
        if (left == deepest && right == deepest) {
            lca = node;
        }
        return Math.max(left, right);
    }
}
