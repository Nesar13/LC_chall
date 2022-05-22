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
        
        if (node==null) return node; 
        HashMap<Node, Node> map=new HashMap<>();
        // HashSet<Node> visited=new HashSet<>(); 
   
        Deque<Node> q=new ArrayDeque<>(); 
        map.put(node, new Node(node.val)); 
        q.offer(node); 
        while(!q.isEmpty()){
            
            Node curr=q.poll(); 
            for (Node n: curr.neighbors){
                
                if (!map.containsKey(n)) {
                map.putIfAbsent(n, new Node(n.val)); 
                q.offer(n); 
                    
                }
                map.get(curr).neighbors.add(map.get(n)); 
                    
            }
            
            
        }
        
      
        
        return map.get(node);
        
    }
}