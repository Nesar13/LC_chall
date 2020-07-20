public class Lc105_ConstuctBTfromTraversals {
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }


        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;


        }
        @Override
        public String toString() {
            return "TreeNode{" +
                    "val=" + val +
                    ", left=" + left +
                    ", right=" + right +
                    '}';
        }
    }
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return helper(preorder, 0, inorder, 0, inorder.length - 1);
    }
    // Everytime we just need to know the root index in preorder array
    private TreeNode helper(int[] preorder, int index, int[] inorder, int lo, int hi) {
        if (lo > hi) return null;
        TreeNode root = new TreeNode(preorder[index]);
        // i is the count of nodes in left sub tree
        int i = 0;
        while (inorder[lo + i] != preorder[index]) ++i;
        root.left = helper(preorder, index + 1, inorder, lo, lo + i - 1);
        root.right = helper(preorder, index + 1 + i, inorder, lo + i + 1, hi);
        return root;
    }
        public static void main(String[] args) {

        }

}
