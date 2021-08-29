public class Lc669_TrimBinaryTree_M {

    public static TreeNode trimBST(TreeNode root, int low, int high) {
        if (root == null) return root;
        if (root.val > high) return trimBST(root.left, low, high);
        if (root.val < low) return trimBST(root.right, low, high);

        root.left = trimBST(root.left, low, high);
        root.right = trimBST(root.right, low, high);
        return root;
    }
    public static void main(String[] args) {

        TreeNode root=new TreeNode(3);

        root.left=new TreeNode(0);

        root.left.right=new TreeNode(2);

        root.left.right.left=new TreeNode(1);

        root.right=new TreeNode(4);


        System.out.println(trimBST(root, 1, 3));
    }
}
