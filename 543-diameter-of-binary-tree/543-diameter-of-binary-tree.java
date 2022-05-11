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
    
    int res=Integer.MIN_VALUE; 
    public int diameterOfBinaryTree(TreeNode root) {
        
        helper(root); 
        return res; 
        
        
    }
    
    int helper(TreeNode root){
              if (root==null) return 0; 
        
        
        int left=helper(root.left); 
        int right=helper(root.right); 
        
        res=Math.max(left + right, res); 
        return Math.max(left, right) +1; 
        
        
    }
}