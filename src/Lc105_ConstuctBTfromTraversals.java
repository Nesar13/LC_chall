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

    /**
     * You can get the root from the first index in
     * preorder, and the left and right subtree in the inorder
     * @param preorder
     * @param inorder
     * @return
     */
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        int preStart = 0;
        int preEnd = preorder.length-1;
        int inStart = 0;
        int inEnd = inorder.length-1;

        return construct(preorder, preStart, preEnd, inorder, inStart, inEnd);
    }

    public TreeNode construct(int[] preorder, int preStart, int preEnd, int[] inorder, int inStart, int inEnd){
        if(preStart>preEnd||inStart>inEnd){
            return null;
        }

        int val = preorder[preStart];
        TreeNode p = new TreeNode(val);

        //find parent element index from inorder
        int k=0;
        for(int i=0; i<inorder.length; i++){
            if(val == inorder[i]){
                k=i;
                break;
            }
        }

        p.left = construct(preorder, preStart+1, preStart+(k-inStart), inorder, inStart, k-1);
        p.right= construct(preorder, preStart+(k-inStart)+1, preEnd, inorder, k+1 , inEnd);

        return p;
    }
        public static void main(String[] args) {

        int[] preorder={3,9,20,15, 7};
        int[] inorder={9,3,15,20,7};


        }

        static void bt(int[] preorder, TreeNode root){
            int size=preorder.length;

            dfs(root, preorder);



        }

        static TreeNode dfs(TreeNode root,int[] preorder){
            if(root==null) return root;

            for (int i = 0; i <preorder.length; i++) {
                TreeNode node=new TreeNode(preorder[i]);
                dfs(root.left, preorder);
                dfs(root.right, preorder);
                return root;
            }




        return null;
        }

        }

