import com.sun.source.tree.Tree;

import java.util.List;

public class Lc107_BST_TreeTraversal {

    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> result=null;


        return result;
          }


    public static void main(String[] args) {
        TreeNode root=new TreeNode(3);
        root.left=new TreeNode(9);
        root.right=new TreeNode (20);
        root.right.left=new TreeNode(15);
        root.right.right=new TreeNode(7);




 /*  root.children.add(new Node (4));
   root.children.add(new Node(5));
   root.children.add(new Node(6));
   root.children.get(0).children.add(new Node (2));
   root.children.get(0).children.add(new Node (8));*/
    }

}


class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
