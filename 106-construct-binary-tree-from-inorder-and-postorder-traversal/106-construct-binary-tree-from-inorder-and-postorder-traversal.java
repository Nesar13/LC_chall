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
    
    int postIndex=0;  
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        postIndex=postorder.length-1; 

        return dfs(inorder, postorder, 0, inorder.length-1);  
        
    }
    
    
    TreeNode dfs(int[] inorder, int[] postorder, int start, int end){
        
        if (start > end) return null; 
        
        TreeNode root=new TreeNode(postorder[postIndex--]);
        
        if(start==end) 
            return root; 
        int index=searchIndex(inorder, root.val); //current val
        
        
        root.right=dfs(inorder, postorder, index+1, end); 
        root.left=dfs(inorder, postorder, start, index-1); 
        
        return root; 
        

        
        
        
    }
    
    
    
    //return Index in inorder 
    int searchIndex(int[] inorder, int val){
        
        for (int i=0; i < inorder.length; i++){
            
            if(inorder[i]==val) return i; 
        }
        
        return -1; 
    }
}