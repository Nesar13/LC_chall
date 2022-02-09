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
    public List<TreeNode> delNodes(TreeNode root, int[] to_delete) {
        
        Set<Integer> set=new HashSet<>(); 
        List<TreeNode> res=new ArrayList<>(); 
        for (int num: to_delete) set.add(num);
  
        removeNode(root, set, res);
        if (!set.contains(root.val)) res.add(root); 
        
        
        return res; 
        
    }
    
    
    TreeNode removeNode(TreeNode root, Set<Integer> set, List<TreeNode> res){
        
        if (root==null) return null; 
        
        root.left=removeNode(root.left, set, res); 
        root.right=removeNode(root.right, set, res); 
        
        if (set.contains(root.val)){
            
            if (root.left != null) res.add(root.left); 
            if (root.right != null) res.add(root.right); 
            
            return null; // very important to return null for deleted num
        }
        
        return root; 
        
        
    }
}