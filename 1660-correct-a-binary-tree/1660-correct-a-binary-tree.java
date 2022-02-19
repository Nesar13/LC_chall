/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
       public TreeNode correctBinaryTree(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        Set<TreeNode> set = new HashSet<>();
        set.add(root);
        while(!queue.isEmpty()) {
            TreeNode curr = queue.remove();
            if(curr.right != null) {
                if(curr.right.right != null && set.contains(curr.right.right)) {
                    curr.right = null;
                    return root;
                }
                set.add(curr.right);
                queue.add(curr.right);
            }
            if(curr.left != null) {
                if(curr.left.right != null && set.contains(curr.left.right)) {
                    curr.left = null;
                    return root;
                }
                set.add(curr.left);
                queue.add(curr.left);
            }
        }
        return root;
    }
}