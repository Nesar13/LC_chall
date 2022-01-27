/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};
*/

class Solution {
    
    
    List<Integer> res;
    public List<Integer> postorder(Node root) {
        res=new ArrayList<>(); 
        
        if (root == null) return res; 
        helper(root); 
        
        res.add(root.val); 
   
        return res; 
        
        
        
        
    }
    
    
    List<Integer> helper(Node root){
        
        if (root == null) return res; 
        
        for (Node r: root.children){
            helper(r); 
            res.add(r.val); 
        }
        
   
        return res; 
        
    }
    
    
}