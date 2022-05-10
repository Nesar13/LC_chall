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

    int res=0; 
    public int goodNodes(TreeNode root) {
        helper(root, root.val); 
       return res; 
        
    }
    
    void helper(TreeNode root, int maxPath){
        if (root==null) return; 
        if (root.val >= maxPath) res++; 
        
        maxPath=Math.max(maxPath, root.val); 
        helper(root.left, maxPath); 
        helper(root.right, maxPath); 
        
        return; 
        
    }
    
 
}