/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

class Solution {
    public Node cloneGraph(Node node) {
        
        if(node == null) return node; 
        HashMap<Node, Node> map=new HashMap<>(); 
        ArrayDeque<Node> q=new ArrayDeque<>(); 
        HashSet<Integer> visited=new HashSet<>(); 
        q.offer(node); 
        map.put(node, new Node(node.val)); 
        
        while(!q.isEmpty()){
            Node temp=q.poll(); 
            for (Node neighbor: temp.neighbors){
                
                if(!visited.contains(neighbor.val)){
                    map.put(neighbor, new Node(neighbor.val)); 
                    visited.add(neighbor.val); 
                    q.offer(neighbor);
                   
                }
                map.get(temp).neighbors.add(map.get(neighbor));
            
                
            }
            
        }
                
                
                
        return map.get(node); 
        
        
    }
}