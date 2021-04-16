public class Lc98_ValidateBinarySearchTree_M {

    //           5
    //          / \
    //         3   6
    // For this instance, we have to ensure that 5 is < the MAX_VALUE, and greater than MIN VALUE
    // 3 would have to be less than 5 which is the max value now  and greater than min value
    // so we recursively put this restriction on each node and return true or false
    // TC: O(N) ….SC:O(d) d is the depth since we are calling to the depth on the call stack
    public boolean isValidBST(TreeNode root) {

        return helper(root, Long.MIN_VALUE, Long.MAX_VALUE);

    }
    private boolean helper(TreeNode root, long minValue, long maxValue) {

        if (root==null) return true;

        if (root.val <= minValue || root.val >= maxValue ) return false;

        boolean left= helper(root.left, minValue, root.val);

        boolean right=helper(root.right, root.val, maxValue);

        return left && right;

    }



}
