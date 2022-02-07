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
    public int sumNumbers(TreeNode root) {
        
        StringBuilder sb=new StringBuilder(); 

        
        dfs(sb, root); 
        
        return res; 
        
        
        
    }
    
    
    void dfs(StringBuilder sb, TreeNode root){
        if (root==null) return; 
        
        sb.append(root.val);
        if (root.left==null && root.right==null){
            res += Integer.valueOf(sb.toString()); 
        }
      
        
        dfs(sb, root.left); 
       
        dfs(sb, root.right); 
        sb.deleteCharAt(sb.length()-1);
         
        
        return; 
        
    }
}