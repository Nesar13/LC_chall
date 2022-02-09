import com.sun.security.jgss.GSSUtil;

import java.util.LinkedList;
import java.util.Queue;

public class Lc1302_DeepestLeavesSum_M {

    public static int deepestLeavesSum(TreeNode root) {
        Queue<TreeNode> q=new LinkedList<>();
        int sum=0;
        q.offer(root);
        while(!q.isEmpty()) {
            int size=q.size();
            sum=0;
            for(int i=0;i<size;i++) {
                TreeNode cur=q.poll();
                sum+=cur.val;
                if(cur.left!=null) q.offer(cur.left);
                if(cur.right!=null) q.offer(cur.right);
            }
        }
        return sum;
    }

    public static void main(String[] args) {

        //Input: root = [1,2,3,4,5,null,6,7,null,null,null,null,8]
        //Output: 15

        TreeNode root=new TreeNode(1);
        root.left=new TreeNode(2);
        root.right=new TreeNode(3);
        root.left.left=new TreeNode(4);
        root.left.right=new TreeNode(5);
        root.right.right=new TreeNode(6);
        root.left.left.left=new TreeNode(7);
        root.right.right.right=new TreeNode(8);

        System.out.println(deepestLeavesSum(root));




    }

      public static class TreeNode {
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
}
