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
    
//     int currSum; 
//     public TreeNode bstToGst(TreeNode root) {
//     int sum=0; 
//      helper(root, sum); 
        
//      return root;    
//     }
    
    
//     int helper(TreeNode root, int sum){
        
//      if (root==null) return 0; 
        
//         int right = helper(root.right, sum); 
         
//         sum= root.val = root.val  + sum+ right; 
//         int left = helper(root.left, sum); 
        
     
//         return sum ; 
        
        
//     }
    
  
    // no global variables
    //
    	public TreeNode bstToGst(TreeNode root) {
        helper(root, 0);
        return root;
    }
    
    public int helper(TreeNode root, int sum) {
        if(root==null) return sum; // notice that we don't want to return 0 if null
        
        // notice we pass sum, it is essentially the previous sum
        sum = helper(root.right, sum);
        // change the root value
        root.val += sum;
        // get updated value from the left
        int fromLeft = root.val;
        // notice we pass the current total to left
        fromLeft = helper(root.left, root.val); 
        return fromLeft;
    }

}