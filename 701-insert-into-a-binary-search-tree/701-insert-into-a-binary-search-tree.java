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
    public TreeNode insertIntoBST(TreeNode root, int val) {
        
        if(root==null) return new TreeNode(val);
        
        dfs(root, val); 
        
        return root; 
    }
    
    void dfs(TreeNode root, int val){
        
        if (root==null) return; 
        
        if (root.left==null && val < root.val){
            root.left=new TreeNode(val); 
        }
         if (root.right==null && val > root.val){
            root.right=new TreeNode(val); 
        }
        
        if (val < root.val)
            dfs(root.left, val); 
        if (val > root.val)
            dfs(root.right, val); 
    }
}