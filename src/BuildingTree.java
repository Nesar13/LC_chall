import java.util.LinkedList;
import java.util.Queue;

public class BuildingTree {
    TreeNode root = buildTree(new Integer[]{
            4, -7, -3, null, null, -9, -3, 9, -7, -4, null, 6, null, -6, -6, null, null, 0, 6, 5, null, 9, null, null, -1, -4, null, null, null, -2});



    public TreeNode buildTree(Integer[] arr) {
        TreeNode root = null;
        Queue<TreeNode> q = new LinkedList<>();
        int i = 0;
        TreeNode t = arr[i] == null ? null : new TreeNode(arr[i]);
        root = t;
        q.add(root);
        i++;
        while (!q.isEmpty() && i < arr.length) {
            TreeNode t1 = q.poll();
            if (t1 != null) {
                t1.left = arr[i] == null ? null : new TreeNode(arr[i]);
                q.add(t1.left);
                i++;
                if (i >= arr.length) {
                    break;
                }
                t1.right = arr[i] == null ? null : new TreeNode(arr[i]);
                q.add(t1.right);
                i++;
            }
        }
        printLevelOrder(root);
        return root;
    }

    // just printing level order
    public void printLevelOrder(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        StringBuilder sb = new StringBuilder();
        while (!q.isEmpty()) {
            TreeNode t = q.poll();
            sb.append(t == null ? "null" : t.val).append(", ");
            if (t != null) {
                q.add(t.left);
                q.add(t.right);
            }
        }
        System.out.println(sb.toString());
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

     @Override
     public String toString() {
         return "TreeNode{" +
                 "val=" + val +
                 ", left=" + left +
                 ", right=" + right +
                 '}';
     }
 }
