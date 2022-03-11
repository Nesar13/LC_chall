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
    public int countUnivalSubtrees(TreeNode root) {
    if (root==null) return 0;
   
     helper(root); 
    return res; 
    }
    
   boolean helper(TreeNode root){
         if (root==null) return true; 
        
        boolean left= helper(root.left); 
        boolean right = helper(root.right); 
        
       // if left and right are true, it can mean that they were null or something
       // we need to verify that the left and right are equal to val before we return true
       if(left && right){
           if(root.left != null && root.val !=root.left.val) return false; 
           if (root.right != null && root.val != root.right.val) return false; 
           
           res++; 
           return true; 
       }
    
       return false; 
        
    }
}