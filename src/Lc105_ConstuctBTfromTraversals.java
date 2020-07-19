public class Lc105_ConstuctBTfromTraversals {
    static class TreeNode {
        int val;
        Lc107_BST_TreeTraversal.TreeNode left;
        Lc107_BST_TreeTraversal.TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }


        TreeNode(int val, Lc107_BST_TreeTraversal.TreeNode left, Lc107_BST_TreeTraversal.TreeNode right) {
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
        public static void main(String[] args) {

        }
    }
}
