public class Lc236_LowestCommonAncestorofBinaryTree_M {

    private TreeNode ans = null;

    public static void main(String[] args) {

    }

    // recursively check for p and q and set a boolean flag when we reach it
    // we add up the tall on the left and right to see if it's
    // the LCA
    // TC: O(N) SC: O(N) depth of tree on stack
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {

        helper(root, p, q);


        return ans;
    }

    private boolean helper(TreeNode root, TreeNode p, TreeNode q) {

        if (root == null) return false;

        int left = helper(root.left, p, q) ? 1 : 0;
        int right = helper(root.right, p, q) ? 1 : 0;

        // we will check if the current node matches p or q
        //mid is basically to make sure we check our initial condition
        // is set to 1
        int mid = (root == p || root == q) ? 1 : 0;

        // we add up the tally, our answer is if they're more than two
        if (left + right + mid >= 2) ans = root;

        // here
        return (left + right + mid) > 0;
    }
}
