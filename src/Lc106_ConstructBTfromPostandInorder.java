import java.util.HashMap;

public class Lc106_ConstructBTfromPostandInorder {

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
            this.right = right;}

        @Override
        public String toString() {
            return "TreeNode{" +
                    "val=" + val +
                    ", left=" + left +
                    ", right=" + right +
                    '}';
        }}

    static HashMap<Integer, Integer> i_map=new HashMap<>();
    static int postindex;
    public static TreeNode buildTree(int[] inorder, int[] postorder) {

        for (int i = 0; i < inorder.length; i++) {

            //caching the inorder
            i_map.put(inorder[i], i);
        }
        postindex=postorder.length-1;
        return recursion(inorder, postorder, 0, inorder.length-1);

    }

    private static TreeNode recursion(int[] inorder, int[] postorder, int start, int end) {
        if (start>end)
            return null;
        TreeNode root=new TreeNode(postorder[postindex--]);

        if(root==null)
            return null;

        if(start==end)
            return root;

        int index=i_map.get(root.val);

        //note when using postorder, do right side first
        root.right=recursion(inorder, postorder, index+1, end);
        root.left=recursion(inorder, postorder, start, index-1);

        return root;

    }


    public static void main(String[] args) {
        int[] postorder={9,15,7,20,3};
        int[] inorder={9,3,15,20,7};

        /*System.out.println(buildTree(inorder, postorder));*/

    }

}
