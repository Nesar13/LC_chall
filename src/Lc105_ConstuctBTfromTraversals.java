import org.w3c.dom.ls.LSOutput;

import java.util.HashMap;

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
            this.right = right;}

        @Override
        public String toString() {
            return "TreeNode{" +
                    "val=" + val +
                    ", left=" + left +
                    ", right=" + right +
                    '}';
        }}


    /**
     * You can get the root from the first index in
     * preorder, and the left and right subtree in the inorder
     * @param preorder
     * @param inorder
     * @return
     */
    /*public static TreeNode buildTree(int[] preorder, int[] inorder) {
        int preStart = 0;
        int preEnd = preorder.length-1;
        int inStart = 0;
        int inEnd = inorder.length-1;

        return construct(preorder, preStart, preEnd, inorder, inStart, inEnd);
    }

    public static TreeNode construct(int[] preorder, int preStart, int preEnd, int[] inorder, int inStart, int inEnd){
        if(preStart>preEnd||inStart>inEnd){
            return null;
        }

        //val is the first index in preorder which means it is the root
        //val is the value in order from the preorder array
        int val = preorder[preStart];
        TreeNode p = new TreeNode(val);

        //find parent element index from inorder
        //k is the index of an element found in inorder from the value of preorder
        int k=0;
        for(int i=0; i<inorder.length; i++){
            if(val == inorder[i]){
                k=i;
                break;
            }
        }
       *//* System.out.println("2nd: "+(preStart+1) + " 3rd: "+ (preStart+(k-inStart)) + " 4th(inorder): "+ inorder + " 5th(instart): "+ inStart + " 6th(inend): " + (k-1) );*//*
        p.left = construct(preorder, preStart+1, preStart+(k-inStart), inorder, inStart, k-1);
        System.out.println("k-instart: "+(k-inStart));
        System.out.println("prestart: " +preStart);
        p.right= construct(preorder, preStart+(k-inStart)+1, preEnd, inorder, k+1 , inEnd);

        return p;
    }*/
    public static TreeNode buildTree(int[] preorder, int[] inorder) {
        return helper(0, 0, inorder.length - 1, preorder, inorder);
    }

    public static TreeNode helper(int preStart, int inStart, int inEnd, int[] preorder, int[] inorder) {
        if (preStart > preorder.length - 1 || inStart > inEnd) {
            return null;
        }
        TreeNode root = new TreeNode(preorder[preStart]);
        int inIndex = 0; // Index of current root in inorder
        for (int i = inStart; i <= inEnd; i++) {
            if (inorder[i] == root.val) {
                inIndex = i;
            }
        }
        root.left = helper(preStart + 1, inStart, inIndex - 1, preorder, inorder);
        root.right = helper(preStart + inIndex - inStart + 1, inIndex + 1, inEnd, preorder, inorder);
        return root;
    }
    //caching the inorder indexes in a hashmap
    HashMap<Integer, Integer> inorderMap=new HashMap<>();
    int preIndex=0;

    public TreeNode buildTree2(int[] preorder, int[] inorder){
        for (int i = 0; i < inorder.length; i++) {
            inorderMap.put(inorder[i], i);
        }
        return helper(preorder, inorder, 0, inorder.length-1);
    }
//TODO: I changed
    private TreeNode helper(int[] preorder, int[] inorder, int start, int end) {

        if(start > end)
            return null;

        TreeNode root= new TreeNode(preorder[preIndex++]);

        if (root == null)
            return null;

        if (start == end) //this happens on the leaves of the tree
            return root;


        int index=inorderMap.get(root.val);

        root.left=helper(preorder, inorder, start, index-1);
        root.right=helper(preorder, inorder, index+1, end);
        return root;
    }
    public int minDepth(TreeNode root) {




return 0;
    }
    public static void main(String[] args) {

        int[] preorder={3,9,20,15, 7};
        int[] inorder={9,3,15,20,7};

        System.out.println('C'-'A');
        /*System.out.println(buildTree(preorder, inorder));*/

        }

        static void bt(int[] preorder, TreeNode root){
            int size=preorder.length;

            dfs(root, preorder);



        }

    /**
     *
     * @param root
     * @param preorder
     * @return
     */
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

