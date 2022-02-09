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
    
   // 1) realize that post is LRroot so we can search for root in the postorder
    // we just have to keep a left and right boundary in the postorder 
    // 2) we just have a globable preIndex that we constantly increment
    // and get the mid(aka root) so we know everything to left is going to be left and right
    // children
    // O(N) time | O(N) space
    
    HashMap<Integer, Integer> postMap;
    int preIndex=0; 
    public TreeNode constructFromPrePost(int[] pre, int[] post) {
        
        postMap=new HashMap<>(); 
        for (int i=0; i < post.length; i++)  
            postMap.put(post[i], i); 
        
       return helper( pre, post,  0, post.length-1); 
    }
    
    
    
    TreeNode helper(int[] pre, int[] post, int i, int j){
        if (i >j) return null;
        TreeNode root=new TreeNode(pre[preIndex++]); 
       
        if (i==j) return root; // because we completed the subtree
        int mid=postMap.get(pre[preIndex]);
        
        root.left=helper(pre, post, i, mid); 
        root.right=helper(pre, post, mid+1, j-1); // note that right side is j-1 so we lower boundary
        
        
        return root; 
        
    }
}