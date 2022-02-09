/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    
    public Node() {
        children = new ArrayList<Node>();
    }
    
    public Node(int _val) {
        val = _val;
        children = new ArrayList<Node>();
    }
    
    public Node(int _val,ArrayList<Node> _children) {
        val = _val;
        children = _children;
    }
};
*/

class Solution {
    public Node findRoot(List<Node> tree) {
        

        
        int sum=0; 
        
        for (int i =0; i < tree.size();i++) {
            
            Node curr=tree.get(i); 
            
            sum += curr.val; 
            for(Node child: curr.children){
               sum -=child.val; 
            }
        }
        
        
        
        for (Node n: tree) {
            
            if(n.val==sum) return n;  
        }
        
        
        return null; 
        
    }
}