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
     public String getDirections(TreeNode root, int startValue, int destValue) {
        StringBuilder sb1 = new StringBuilder(), sb2 = new StringBuilder();
        helper(root, startValue, sb1);
        helper(root, destValue, sb2);
        String s1 = sb1.reverse().toString();
        String s2 = sb2.reverse().toString();
        
        int count = 0, i = 0, j = 0;
        while (i < s1.length() && j < s2.length()) {
            if (s1.charAt(i) == s2.charAt(j)) {
                i++;
                j++;
                count++;
            } else
                break;
        }
        
        return "U".repeat(s1.length() - count) + s2.substring(count);
    }
    
    private boolean helper(TreeNode node, int target, StringBuilder sb) {
        if (node == null) return false;
        if (node.val == target) return true;
        boolean left = helper(node.left, target, sb);
        boolean right = helper(node.right, target, sb);
        if (left)
            sb.append("L");
        else if (right)
            sb.append("R");
        return left || right;
    }
}