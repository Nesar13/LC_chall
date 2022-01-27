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
    
    
  
    public List<Integer> postorder(Node root) {
  
        List<Integer> res=new ArrayList(); 
        if (root==null) return res; 
        
        
        ArrayDeque<Node> stack=new ArrayDeque(); 
        
        stack.push(root); 
        
        while (!stack.isEmpty()){
            
            
            Node curr=stack.pop();  
            int N=curr.children.size();
            res.add(curr.val);
            for (int i =0; i < N ; i++){
                
                stack.push(curr.children.get(i)); 
            }
        }
        Collections.reverse(res);
        return res ; 
        
    }
    
    
   
    
}