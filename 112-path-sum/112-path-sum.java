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
    public boolean hasPathSum(TreeNode root, int targetSum) {
        
        return dfs(root, targetSum, 0);
        
    }
    
    
    boolean dfs(TreeNode root, int targetSum, int curr){
        
      if (root==null ) return false;
      if (targetSum==curr+root.val && (root.left==null && root.right==null)) return true; 
       boolean left=dfs(root.left, targetSum, curr+root.val); 
       boolean right=dfs(root.right, targetSum,curr+root.val );
       
        return left || right; 
    }
    
   
}