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
    
    //
    
    
//     private int preindex = 0;
// public TreeNode constructFromPrePost(int[] pre, int[] post) {
//     HashMap<Integer, Integer> postMap = new HashMap<>();
//     for(int i = 0; i < post.length; i++)
//         postMap.put(post[i], i);
//     return helper(pre, postMap, 0, post.length-1);
// }

// private TreeNode helper(int[] pre, HashMap<Integer, Integer> postMap, int low, int high) {
//     if(low > high)
//         return null;
    
//     TreeNode node = new TreeNode(pre[preindex++]);
//     if(low == high)
//         return node;
    
//     int mid = postMap.get(pre[preindex]);
//     node.left = helper(pre, postMap, low, mid);
//     node.right = helper(pre, postMap, mid+1, high-1);
//     return node;
// }
    HashMap<Integer, Integer> postMap;
    int preIndex=0; 
    public TreeNode constructFromPrePost(int[] pre, int[] post) {
        
        postMap=new HashMap<>(); 
        for (int i=0; i < post.length; i++){
            
            postMap.put(post[i], i); 
        }
        
     
        
        
       return helper( pre, post,  0, post.length-1); 
       

    }
    
    
    
    TreeNode helper(int[] pre, int[] post, int i, int j){
        
        
        if (i >j) return null;
        
      
        TreeNode root=new TreeNode(pre[preIndex++]); 
       
        if (i==j) return root; 
        int mid=postMap.get(pre[preIndex]); 
        root.left=helper(pre, post, i, mid); 
        root.right=helper(pre, post, mid+1, j-1);
        
        
        return root; 
        
    }
}