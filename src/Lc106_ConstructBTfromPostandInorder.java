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

    HashMap<Integer, Integer> i_map=new HashMap<>();
    int postindex;
    public TreeNode buildTree(int[] inorder, int[] postorder) {

        for (int i = 0; i < inorder.length; i++) {

            //caching the inorder
            i_map.put(inorder[i], i);


        }

        return recursion(inorder, postorder, 0, inorder.length-1);

    }

    private TreeNode recursion(int[] inorder, int[] postorder, int start, int end) {
        if (start>end)
            return null;
        TreeNode root=new TreeNode(postindex++);

        if(root==null)
            return null;

        if(start==end)
            return null;

        int index=i_map.get(root.val);


        root.left=recursion(inorder, postorder, start, index-1);
        root.right=recursion(inorder, postorder, index-1, end );



    }


    public static void main(String[] args) {
        int[] postorder={9,15,7,20,3};
        int[] inorder={9,3,15,20,7};

        /*System.out.println(buildTree(preorder, inorder));*/

    }

}
