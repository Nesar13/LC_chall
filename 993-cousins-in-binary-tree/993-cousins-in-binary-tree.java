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
    int xParent; 
    int yParent;
    int xDepth;
    int yDepth; 
    public boolean isCousins(TreeNode root, int x, int y) {
        
        xParent=-1; 
        yParent=-1;
        xDepth=-1; 
        yDepth=-1; 
        
       // find depth of both 
        // find parents of both
        find(root, x, y, 0); 
        if (xParent != -1 && yParent != -1 && (xParent != yParent) && yDepth !=-1 && (yDepth == xDepth)) return true; 
        return false; 
    
    }
    
    void find(TreeNode root, int x, int y, int depth){
        if (root==null) return; 
        
        if (root.left != null && root.left.val==x) {
            xParent=root.val; 
            xDepth=depth+1; 
            
            
        }
        if (root.left != null && root.left.val==y) {
            yParent=root.val; 
            yDepth=depth+1; 
        }
        if (root.right != null && root.right.val==x) {
            xParent=root.val; 
            xDepth=depth+1; 
        }
        if (root.right != null && root.right.val==y) {
            yParent=root.val;
            yDepth=depth+1; 
        }
        
        find(root.left, x, y, depth+1); 
        find(root.right, x, y, depth+1); 
        
        
    }
    
   
}