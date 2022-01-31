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
        
        Set<Node> set=new HashSet(); 
        
        
        
        for (int i =0; i < tree.size();i++) {
            
            Node curr=tree.get(i); 
            
            for(Node child: curr.children){
                set.add(child); 
            }
        }
        
        
        
        for (int i =0; i < tree.size();i++) {
            
            if(!set.contains(tree.get(i))) return tree.get(i); 
        }
        
        
        return null; 
        
    }
}