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
    public int maxAncestorDiff(TreeNode root) {
        
        return helper(root, root.val, root.val); 
        
        
    }
    
    
   int helper(TreeNode root, int currMin, int currMax){
        if (root==null) return Math.abs(currMax-currMin); 
        
        int min=Math.min(root.val, currMin); 
        int max=Math.max(root.val, currMax); 
        
        int left=helper(root.left, min, max);
       int right=helper(root.right, min, max); 
       
       return Math.max(left, right); 
        
    }
}