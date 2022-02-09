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
    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        if(root1==null || root2==null) return false; 
        List<Integer> arr1=new ArrayList<>(); 
        List<Integer> arr2=new ArrayList<>(); 
        getLeaves(root1, arr1);
        getLeaves(root2, arr2); 
        
        return arr1.equals(arr2);  
    }
    
    TreeNode getLeaves(TreeNode root, List<Integer> arr){
        if (root==null) return null; 
        
        root.left=getLeaves(root.left, arr); 
        root.right=getLeaves(root.right, arr); 
        
        if (root.left ==null && root.right == null) {
            arr.add(root.val); 
        }
        
        return root; 
        
    }
}