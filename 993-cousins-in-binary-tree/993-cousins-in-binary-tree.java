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
    // Handle cases where they share same parent
    //count depth
    
    int parentX=-1; 
    int parentY=-1; 
    int depthX=-1; 
    int depthY=-1; 
    public boolean isCousins(TreeNode root, int x, int y) {
        
        
        findCousins(root, x, y, 0); 
        if (parentX != -1 && parentX !=parentY && depthX != -1 && depthX==depthY){
            return true; 
        }
        return false; 
    }
    
    
    
    void findCousins(TreeNode root, int x, int y, int depth){
        if(root==null) return; 
        
          if (root.left != null && root.left.val==x ){
             depthX=depth+1; 
            parentX=root.val;
        }
        if ( root.right != null && root.right.val==x){
            depthX=depth+1; 
            parentX=root.val; 
        }
        if (root.left != null && root.left.val==y ){
            depthY=depth+1; 
            parentY=root.val; 
        }
        if ( root.right != null && root.right.val==y){
            depthY=depth+1; 
            parentY=root.val; 
        }
    
        
        findCousins(root.left, x, y, depth+1); 
        findCousins(root.right, x, y, depth+1); 
        
      
        
        
        return; 
        
        
    }
}